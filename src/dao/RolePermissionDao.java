/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import beans.PermissionBean;
import beans.RoleBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface RolePermissionDao {
    public List<PermissionBean> getAllPermissions();
    public PermissionBean getPermissionByName(String permission);
    public List<PermissionBean> getAssignedPermissions(RoleBean role);
    public List<PermissionBean> getUnassigndPermissios(RoleBean role);
    public int assignPermissions(List<PermissionBean> permissions, RoleBean role);
    public int revokePermissions(List<PermissionBean> permissions, RoleBean role);
}
