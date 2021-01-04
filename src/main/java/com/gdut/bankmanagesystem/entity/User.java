package com.gdut.bankmanagesystem.entity;

import lombok.*;

/**
 * @author honzooban
 * @version 1.0.0
 * @ClassName User.java
 * @Description
 * @createTime 2021年01月04日 01:50:00
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String password;
    private Integer role;
    private Long cId;
    private Long eId;
    private Long aId;
}
