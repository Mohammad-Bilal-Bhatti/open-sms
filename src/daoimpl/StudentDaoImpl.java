/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.StudentBean;
import connection.DBConnection;
import dao.StudentDao;

/**
 *
 * @author Javed Ali Dahri
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public ResultSet getAllStudents() {

        //    ArrayList<StudentBean> students = new ArrayList<StudentBean>();
        //    StudentBean student;
        ResultSet rs = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from student where active = ?");
            pst.setString(1, "1");
            rs = pst.executeQuery();

        } catch (SQLException se) {

        }

        return rs;

    }

    @Override
    public int addStudent(StudentBean student) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(
                    "Insert into student(s_name,surname,gender,guardian,"
                    + "guardian_relation,guardian_contact,dob,cnic,contact_no,address,"
                    + "doa,religion,nationality,pic_path,matric_board,"
                    + "matric_marks,matric_pass_year,matric_seat_no,inter_board,inter_marks,"
                    + "inter_pass_year,inter_seat_no,active,created_by,created_date)"
                    + "values(?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?)");
            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getSurname());
            pst.setString(3, student.getGender());
            pst.setString(4, student.getGuardian());
            pst.setString(5, student.getGuardianRelation());
            pst.setString(6, student.getGuardianContact());
            pst.setString(7, student.getDob());
            pst.setString(8, student.getStudentNic());
            pst.setString(9, student.getContact());
            pst.setString(10, student.getAddress());
            pst.setString(11, student.getAdmissionDate());
            pst.setString(12, student.getReligion());
            pst.setString(13, student.getNationality());
            pst.setString(14, student.getPicturePath());
            pst.setString(15, student.getMatricBoard());
            pst.setInt(16, student.getMatricMarks());
            pst.setString(17, student.getMatricPassYear());
            pst.setString(18, student.getMatricSeatNumber());
            pst.setString(19, student.getInterBoard());
            pst.setInt(20, student.getInterMarks());
            pst.setString(21, student.getInterPassYear());
            pst.setString(22, student.getInterSeatNumber());
            pst.setString(23, "1");//making it active
            pst.setInt(24, student.getCreatedBy());
            pst.setString(25, student.getCreatedDate());

            return pst.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println(se.getMessage());
        }
        return 0;

    }

    @Override
    public int updateStudent(StudentBean student) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update student "
                    + "set s_name =?,surname =?,gender =?,guardian =?,"
                    + "guardian_relation =?,guardian_contact=?,dob =?,cnic =?,contact_no =?,address =?,doa =?,religion =?,"
                    + "nationality =?,pic_path =?,matric_board =?,matric_marks =?,matric_pass_year =?,matric_seat_no =?,"
                    + "inter_board =?,inter_marks =?,inter_pass_year =?,inter_seat_no =?,"
                    + "modified_by =?,modified_date =? "
                    + "where s_id =?");

            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getSurname());
            pst.setString(3, student.getGender());
            pst.setString(4, student.getGuardian());
            pst.setString(5, student.getGuardianRelation());
            pst.setString(6, student.getGuardianContact());
            pst.setString(7, student.getDob());
            pst.setString(8, student.getStudentNic());
            pst.setString(9, student.getContact());
            pst.setString(10, student.getAddress());
            pst.setString(11, student.getAdmissionDate());
            pst.setString(12, student.getReligion());
            pst.setString(13, student.getNationality());
            pst.setString(14, student.getPicturePath());
            pst.setString(15, student.getMatricBoard());
            pst.setInt(16, student.getMatricMarks());
            pst.setString(17, student.getMatricPassYear());
            pst.setString(18, student.getMatricSeatNumber());
            pst.setString(19, student.getInterBoard());
            pst.setInt(20, student.getInterMarks());
            pst.setString(21, student.getInterPassYear());
            pst.setString(22, student.getInterSeatNumber());
            pst.setInt(23, student.getModifiedBy());
            pst.setString(24, student.getModifiedDate());
            pst.setInt(25, student.getStudentId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteStudent(StudentBean student) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update student set active = ?,modified_by = ?,modified_date = ? where s_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, student.getModifiedBy());
            pst.setString(3, student.getModifiedDate());
            pst.setInt(4, student.getStudentId());

            return pst.executeUpdate();

        } catch (SQLException se) {
        }
        return 0;
    }

    @Override
    public StudentBean getStudentById(Integer studentId) {
        StudentBean student = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from student where active = ? and s_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, studentId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                student = new StudentBean();

                student.setStudentId(studentId);
                student.setStudentName(rs.getString("s_name"));
                student.setSurname(rs.getString("surname"));
                student.setGender(rs.getString("gender"));
                student.setGuardian(rs.getString("guardian"));
                student.setGuardianRelation(rs.getString("guardian_relation"));
                student.setGuardianContact(rs.getString("guardian_contact"));
                student.setDob(rs.getString("dob"));
                student.setStudentNic(rs.getString("cnic"));
                student.setContact(rs.getString("contact_no"));
                student.setAddress(rs.getString("address"));
                student.setAdmissionDate(rs.getString("doa"));
                student.setReligion(rs.getString("religion"));
                student.setNationality(rs.getString("nationality"));
                student.setPicturePath(rs.getString("pic_path"));
                student.setMatricBoard(rs.getString("matric_board"));
                student.setMatricMarks(Integer.valueOf(rs.getString("matric_marks")));
                student.setMatricPassYear(rs.getString("matric_pass_year"));
                student.setMatricSeatNumber(rs.getString("matric_seat_no"));
                student.setInterBoard(rs.getString("inter_board"));
                student.setInterMarks(Integer.valueOf(rs.getString("inter_marks")));
                student.setInterPassYear(rs.getString("inter_pass_year"));
                student.setInterSeatNumber(rs.getString("inter_seat_no"));
                student.setCreatedBy(rs.getInt("created_by"));
                student.setCreatedDate(rs.getString("created_date"));
                student.setModifiedBy(rs.getInt("modified_by"));
                student.setModifiedDate(rs.getString("modified_date"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return student;
    }

}
