package com.mooncorp.realtybroker.repository.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter @Setter
public class BasicAuditingProperties {

    @CreatedBy
    @Column(updatable=false)
    private String regId;

    @CreatedDate
    @Column(updatable=false)
    private LocalDateTime regDt;

    @LastModifiedBy
    @Column
    private String mdfyId;

    @LastModifiedDate
    @Column
    private LocalDateTime mdfyDt;

}
