package com.mooncorp.realtybroker.repository;

import com.mooncorp.realtybroker.repository.common.BasicAuditingProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter @Setter @NoArgsConstructor
public class BoardRepository extends BasicAuditingProperties {

    @Id
    private Integer id;

    private String title;
    private String content;
    private Integer attachmentId;
    private Integer like;
    private Integer delYn;

}
