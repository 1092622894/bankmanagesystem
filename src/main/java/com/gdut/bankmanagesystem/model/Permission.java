package com.gdut.bankmanagesystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Permission{
    /*
    权限id
     */
    private Integer permissionId;
    /*
    权限名称
     */
    private String permissionName;
    /*
    权限可以访问的路径
     */
    private String url;

}
