package com.gdut.bankmanagesystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    /*
    用户id
     */
    private Integer userId;
    /*
    用户昵称
     */
    private String username;
    /*
    用户密码
     */
    private String password;
    /*
    MD5盐值的salt
     */
    private String salt;

}
