package com.gdut.bankmanagesystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolePermission{
    /*
    角色权限id
     */
    private Integer rolePermissionId;
    /*
    角色id
     */
    private Integer roleId;
    /*
    权限id
     */
    private Integer permissionId;
}
