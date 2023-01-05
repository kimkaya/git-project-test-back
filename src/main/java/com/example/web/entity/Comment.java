package com.example.web.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentid;
    @Id
    private String userid;
    @Column
    private int type;
    @Column
    private String comment;
    @Column
    private Boolean anonymous;
}