/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Javed Ali Dahri
 */
public class RolePermissionBean extends Bean implements Serializable{
    
    public RolePermissionBean(){}
    
    private Integer rolePermissionId;
    private RoleBean role;
    private PermissionBean permission;

    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }

    public PermissionBean getPermission() {
        return permission;
    }

    public void setPermission(PermissionBean permission) {
        this.permission = permission;
    }
 
    
}
