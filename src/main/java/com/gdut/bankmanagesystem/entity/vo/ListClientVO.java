package com.gdut.bankmanagesystem.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gdut.bankmanagesystem.entity.Client;
import com.gdut.bankmanagesystem.entity.Contacts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月05日 00:46:00
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ListClientVO {

    private Integer userId;

    private Long id;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户手机号码
     */
    private String phone;

    /**
     * 客户家庭地址
     */
    private String address;

    /**
     * 身份证号码
     */
    private String identifyCard;

    /**
     * contacts表主键id
     */
    private Long contactId;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机号码
     */
    private String contactPhone;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 客户与联系人的关系
     */
    private String contactRelation;
}
