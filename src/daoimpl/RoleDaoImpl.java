/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.RoleBean;
import connection.DBConnection;
import dao.RoleDao;

/**
 *
 * @author Javed Ali Dahri
 */
public class RoleDaoImpl implements RoleDao {

    @Override
    public List<RoleBean> getAllRoles() {
        List<RoleBean> roles = new ArrayList<>();
        RoleBean role = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from role where active = ?");
            pst.setString(1, "1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                role = new RoleBean();
                role.setRoleId(rs.getInt("role_id"));
                role.setRole(rs.getString("role"));
                roles.add(role);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return roles;
    }

    @Override
    public int addRole(RoleBean role) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into role(role,active,created_by,created_date) values(?,?,?,?)");
            pst.setString(1, role.getRole());
            pst.setString(2, "1");
            pst.setInt(3, role.getCreatedBy());
            pst.setString(4, role.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateRole(RoleBean role) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update role set role = ?,modified_by = ?,modified_date = ? where role_id = ?");
            pst.setString(1, role.getRole());
            pst.setInt(2, role.getModifiedBy());
            pst.setString(3, role.getModifiedDate());
            pst.setInt(4, role.getRoleId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteRole(RoleBean role) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update role set active  = ?,modified_by = ?,modified_date = ? where role_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, role.getModifiedBy());
            pst.setString(3, role.getModifiedDate());
            pst.setInt(4, role.getRoleId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public RoleBean getRoleById(Integer roleId) {
        RoleBean role = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from role where active = ? and role_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, roleId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                role = new RoleBean();
                role.setRoleId(roleId);
                role.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return role;
    }

}
