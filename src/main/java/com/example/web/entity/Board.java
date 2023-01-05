package com.example.web.entity;

import lombok.*;
;import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postid;
    @Id
    private String userid;
    @Column
    private int type;
    @Column
    private String subject;
    @Column
    private String industry;
    @Column
    private String content;
    @Column
    private Boolean anonymous;
}