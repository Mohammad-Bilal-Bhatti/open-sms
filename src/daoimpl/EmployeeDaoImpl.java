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
import beans.EmployeeBean;
import beans.RoleBean;
import connection.DBConnection;
import dao.EmployeeDao;

/**
 *
 * @author Bilal Bhatti
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public ResultSet getAllEmployees() {
        ResultSet rs = null;
      
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from employee where active = ?");
            pst.setString(1, "1");
            rs = pst.executeQuery();
            
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();

        }
        return rs;
    }

    @Override
    public int addEmployee(EmployeeBean employee) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(
                    "Insert into employee(emp_name,surname,cnic,sal_type,"
                    + "sal_value,contact,dob,gender,address,"
                    + "specialization,experience,hire_date,role_id,user_name, password,q_id, answer,pic_path,"
                    + "active,created_by,created_date)"
                    + "values(?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, employee.getEmpName());
            pst.setString(2, employee.getEmpSurname());
            pst.setString(3, employee.getEmpNic());
            pst.setString(4, employee.getSalType());

            pst.setDouble(5, employee.getSalary());
            pst.setString(6, employee.getContact());
            pst.setString(7, employee.getDob());
            pst.setString(8, employee.getGender());
            pst.setString(9, employee.getAddress());

            pst.setString(10, employee.getSpecialization());
            pst.setString(11, employee.getExperience());
            pst.setString(12, employee.getHiredate());
            pst.setInt(13, employee.getRole().getRoleId());
            pst.setString(14, employee.getUserName());
            pst.setString(15, employee.getPassword());
            pst.setString(16, employee.getqId());
            pst.setString(17, employee.getAnswer());
            pst.setString(18, employee.getPicPath());

            pst.setString(19, "1"); //Setting Active...
            pst.setInt(20, employee.getCreatedBy());
            pst.setString(21, employee.getCreatedDate());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;

    }

    @Override
    public int updateEmployee(EmployeeBean employee) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update employee "
                    + "set emp_name =?,surname =?,cnic =?,sal_type =?,"
                    + "sal_value =?,contact =?,dob =?,gender =?,address =?,specialization =?,"
                    + "experience =?,hire_date =?,role_id =?,user_name= ?, password= ?,q_id =?, answer= ?,pic_path=?,"
                    + "modified_by =?,modified_date =? "
                    + "where emp_id =?");

            pst.setString(1, employee.getEmpName());
            pst.setString(2, employee.getEmpSurname());
            pst.setString(3, employee.getEmpNic());
            pst.setString(4, employee.getSalType());
            pst.setDouble(5, employee.getSalary());
            pst.setString(6, employee.getContact());
            pst.setString(7, employee.getDob());
            pst.setString(8, employee.getGender());
            pst.setString(9, employee.getAddress());
            pst.setString(10, employee.getSpecialization());
            pst.setString(11, employee.getExperience());
            pst.setString(12, employee.getHiredate());
            pst.setInt(13, employee.getRole().getRoleId());
            pst.setString(14, employee.getUserName());
            pst.setString(15, employee.getPassword());
            pst.setString(16, employee.getqId());
            pst.setString(17, employee.getAnswer());
            pst.setString(18, employee.getPicPath());

            pst.setInt(19, employee.getModifiedBy());
            pst.setString(20, employee.getModifiedDate());
            pst.setInt(21, employee.getEmpId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEmployee(EmployeeBean employee) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update employee set active = ?,modified_by = ?,modified_date = ? where emp_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, employee.getModifiedBy());
            pst.setString(3, employee.getModifiedDate());
            pst.setInt(4, employee.getEmpId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }

    @Override
    public EmployeeBean getEmployeeById(Integer empId) {
        EmployeeBean employee = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from employee where active = ? and emp_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, empId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                employee = new EmployeeBean();
                employee.setEmpId(empId);
                employee.setEmpName(rs.getString("emp_name"));
                employee.setEmpSurname(rs.getString("surname"));
                employee.setEmpNic(rs.getString("cnic"));
                employee.setSalType(rs.getString("sal_type"));
                employee.setSalary(rs.getDouble("sal_value"));
                employee.setContact(rs.getString("contact"));
                employee.setDob(rs.getString("dob"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setSpecialization(rs.getString("specialization"));
                employee.setExperience(rs.getString("experience"));
                employee.setHiredate(rs.getString("hire_date"));
                RoleBean role = new RoleDaoImpl().getRoleById(rs.getInt("role_id"));
                employee.setRole(role);
                employee.setUserName(rs.getString("user_name"));
                employee.setPassword(rs.getString("password"));
                employee.setqId(rs.getString("q_id"));
                employee.setAnswer(rs.getString("answer"));
                employee.setCreatedBy(rs.getInt("created_by"));
                employee.setCreatedDate(rs.getString("created_date"));
                employee.setModifiedBy(rs.getInt("modified_by"));
                employee.setModifiedDate(rs.getString("modified_date"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return employee;

    }

    @Override
    public EmployeeBean getEmployeeByName(String employeeName) {
        EmployeeBean employee = new EmployeeBean();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from employee where emp_name = ?");
            pst.setString(1, employeeName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                employee.setEmpId(rs.getInt("emp_id"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<EmployeeBean> getAllOwners() {
        List<EmployeeBean> owners = new ArrayList<>();
        EmployeeBean owner = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from employee where role_id =(Select role_id from role where role = ?)");
            pst.setString(1, "Owner");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                owner = new EmployeeBean();
                owner.setEmpId(rs.getInt("emp_id"));
                owner.setEmpName(rs.getString("emp_name"));
                owners.add(owner);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return owners;
    }

    @Override
    public EmployeeBean checkLogin(EmployeeBean employee) {
        EmployeeBean employeeBean = null;
        RoleBean userRole = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from employee where user_name=? and password=? and active=?");
            pst.setString(1, employee.getUserName());
            pst.setString(2, employee.getPassword());
            pst.setString(3, "1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                employeeBean = new EmployeeBean();
                userRole = new RoleDaoImpl().getRoleById(rs.getInt("role_id"));
                employeeBean.setEmpId(rs.getInt("emp_id"));
                employeeBean.setUserName(rs.getString("user_name"));
                employeeBean.setPassword(rs.getString("password"));
                employeeBean.setEmpName(rs.getString("emp_name"));
                employeeBean.setRole(userRole);
                break;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return employeeBean;
    }

    public int changePassword(EmployeeBean user, String password) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update employee set password=? where emp_id=?");
            pst.setString(1, password);
            pst.setInt(2, user.getEmpId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public EmployeeBean getPassword(String username) {
        EmployeeBean user = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select user_name,password,q_id,answer from employee where user_name=?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new EmployeeBean();
                user.setUserName(username);
                user.setPassword(rs.getString("password"));
                user.setqId(rs.getString("q_id"));
                user.setAnswer(rs.getString("answer"));
                return user;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }
}
