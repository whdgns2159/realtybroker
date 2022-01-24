package com.mooncorp.realtybroker.controller.board;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public ResponseEntity<String> getBoardList(final int page){


        return ResponseEntity.ok().body("aaa");
    }
}
