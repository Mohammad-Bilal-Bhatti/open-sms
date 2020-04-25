/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import beans.RoleBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface RoleDao {
    public List<RoleBean> getAllRoles();
    public int addRole(RoleBean role);
    public int updateRole(RoleBean role);
    public int deleteRole(RoleBean role);
    public RoleBean getRoleById(Integer roleId);
}
