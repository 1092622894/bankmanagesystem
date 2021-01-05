package com.gdut.bankmanagesystem.entity.dto;

import com.gdut.bankmanagesystem.entity.Client;
import com.gdut.bankmanagesystem.entity.Contacts;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author honzooban
 * @version 1.0.0
 */
@ToString
@Getter
@Setter
public class RegisterDTO {

    private Client client;
    private Contacts contacts;
    private String password;

}
