package com.mooncorp.realtybroker.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] unAuthList = {"/login"};  //접근 가능한목록

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        String requestURI = httpReq.getRequestURI();
        HttpSession session = httpReq.getSession(false);    //기 저장된 세션정보가 없을경우 null로 출력
        try {
            if (!PatternMatchUtils.simpleMatch(unAuthList, requestURI)) {
                //접근가능 url목록에 없으면서
                if (session == null || session.getAttribute("Authentication") == null) {
                    //세션값이 없거나 혹은 인증정보가 비어있을경우
                    httpRes.sendRedirect("/login?redirectURL=" + requestURI);
                    httpRes.setContentType("application/json");
                    PrintWriter out = httpRes.getWriter();
                    out.print("{ message : '세션정보가 유효하지 않습니다.'}");
                    out.flush();
                    return;
                }
                //그 이외에는 접근가능
            }

            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("LoginValidFilter 종료");
        }
    }
 }
