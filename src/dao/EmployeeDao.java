/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import beans.EmployeeBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface EmployeeDao {
    public ResultSet getAllEmployees();
    public int addEmployee(EmployeeBean employee);
    public int updateEmployee(EmployeeBean employee);
    public int deleteEmployee(EmployeeBean employee);
    public EmployeeBean getEmployeeById(Integer empId);
    public EmployeeBean getEmployeeByName(String employeeName);
    public List<EmployeeBean> getAllOwners();
    public EmployeeBean checkLogin(EmployeeBean employee);
    public EmployeeBean getPassword(String username);
}
