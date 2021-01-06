package com.gdut.bankmanagesystem.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月04日 16:25:00
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginVo {

    private String token;
    private Object user;
    private Long bankId;

    public LoginVo(String token, Object user) {
        this.token = token;
        this.user = user;
    }

}
