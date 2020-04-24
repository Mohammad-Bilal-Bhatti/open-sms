/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import beans.StudentBean;

/**
 *
 * @author Javed Ali Dahri
 */
public interface StudentDao {
    public ResultSet getAllStudents();
    public int addStudent(StudentBean student);
    public int updateStudent(StudentBean student);
    public int deleteStudent(StudentBean student);
    public StudentBean getStudentById(Integer studentId);
}
