package com.gdut.bankmanagesystem.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月05日 13:36:00
 */
@Getter
@Setter
@ToString
public class ApplyAccountDTO {

    @JsonProperty("cId")
    private Long cId;
    @JsonProperty("bId")
    private Long bId;
    private Integer accountType;
}
