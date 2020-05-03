/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.PermissionBean;
import beans.RoleBean;
import connection.DBConnection;
import dao.RolePermissionDao;

/**
 *
 * @author Bilal Bhatti
 */
public class RolePermissionDaoImpl implements RolePermissionDao {

    @Override
    public List<PermissionBean> getAllPermissions() {
        List<PermissionBean> permissions = new ArrayList<>();
        PermissionBean permission = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from permission");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                permission = new PermissionBean();
                permission.setPermissionId(rs.getInt("permission_id"));
                permission.setPermission(rs.getString("permission_title"));
                permissions.add(permission);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return permissions;
    }

    @Override
    public List<PermissionBean> getAssignedPermissions(RoleBean role) {
        List<PermissionBean> assginPermissions = new ArrayList<>();
        PermissionBean permission = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from permission where permission_id IN(Select permission_id from role_permission where role_id = ?)");
            pst.setInt(1, role.getRoleId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                permission = new PermissionBean();
                permission.setPermissionId(rs.getInt("permission_id"));
                permission.setPermission(rs.getString("permission_title"));
                assginPermissions.add(permission);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return assginPermissions;
    }

    @Override
    public List<PermissionBean> getUnassigndPermissios(RoleBean role) {
        List<PermissionBean> unAssginPermissions = new ArrayList<>();
        PermissionBean permission = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from permission where permission_id NOT IN(Select permission_id from role_permission where role_id = ?)");
            pst.setInt(1, role.getRoleId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                permission = new PermissionBean();
                permission.setPermissionId(rs.getInt("permission_id"));
                permission.setPermission(rs.getString("permission_title"));
                unAssginPermissions.add(permission);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return unAssginPermissions;
    }

    @Override
    public int assignPermissions(List<PermissionBean> permissions, RoleBean role) {
        int check = 0;
        try {
            PreparedStatement pst = null;
            Connection con = DBConnection.getConnection();
            for (PermissionBean permission : permissions) {
                pst = con.prepareStatement("Insert into role_permission(role_id,permission_id)values(?,?)");
                pst.setInt(1, role.getRoleId());
                pst.setInt(2, permission.getPermissionId());
                check = pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public int revokePermissions(List<PermissionBean> permissions, RoleBean role) {
        int check = 0;
        try {
            PreparedStatement pst = null;
            Connection con = DBConnection.getConnection();
            for (PermissionBean permission : permissions) {
                pst = con.prepareStatement("Delete from role_permission where role_id = ? and permission_id = ?");
                pst.setInt(1, role.getRoleId());
                pst.setInt(2, permission.getPermissionId());
                check = pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public PermissionBean getPermissionByName(String permission) {
        PermissionBean permissionBean = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from permission where permission_title = ?");
            pst.setString(1, permission);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                permissionBean = new PermissionBean();
                permissionBean.setPermissionId(rs.getInt("permission_id"));
                permissionBean.setPermission(rs.getString("permission_title"));
                break;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return permissionBean;
    }

}
