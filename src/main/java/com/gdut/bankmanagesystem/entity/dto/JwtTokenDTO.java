package com.gdut.bankmanagesystem.entity.dto;

import lombok.*;

/**
 * @author honzooban
 * @version 1.0.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDTO {

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户角色
     */
    private Integer role;

}
