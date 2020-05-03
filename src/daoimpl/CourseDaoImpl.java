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
import beans.CourseBean;
import connection.DBConnection;
import dao.CourseDao;

/**
 *
 * @author Bilal Bhatti
 */
public class CourseDaoImpl implements CourseDao {

    @Override
    public List<CourseBean> getAllCourses() {
        List<CourseBean> courses = new ArrayList<>();
        CourseBean course = null, mainCourse = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from course where active = ?");
            pst.setString(1, "1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                course = new CourseBean();
                if (rs.getString("main_course") != null) {
                    mainCourse = getParentCourse(rs.getInt("main_course"));
                } else {
                    mainCourse = new CourseBean();
                    mainCourse.setCourseName(null);
                }
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_title"));
                course.setCourseDuration(rs.getString("duration"));
                course.setMainCourse(mainCourse);
                courses.add(course);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return courses;
    }

    @Override
    public int addCourse(CourseBean course) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into course(course_title,duration,main_course,active,created_by,created_date) values(?,?,?,?,?,?)");
            pst.setString(1, course.getCourseName());
            pst.setString(2, course.getCourseDuration());
            if(course.getMainCourse().getCourseId()==0){
                pst.setString(3,null);
            }
            else{
                pst.setInt(3, course.getMainCourse().getCourseId());
            }
            pst.setString(4,"1");
            pst.setInt(5, course.getCreatedBy());
            pst.setString(6, course.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateCourse(CourseBean course) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update course set course_title = ?,duration = ?,main_course = ?,modified_by = ?,modified_date = ? where course_id=?");
            pst.setString(1, course.getCourseName());
            pst.setString(2, course.getCourseDuration());
            if(course.getMainCourse().getCourseId()==0){
                pst.setString(3,null);
            }
            else{
                pst.setInt(3, course.getMainCourse().getCourseId());
            }
            pst.setInt(4, course.getModifiedBy());
            pst.setString(5, course.getModifiedDate());
            pst.setInt(6,course.getCourseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteCourse(CourseBean course) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update course set active = ?,modified_by = ?,modified_date=? where course_id=? or main_course = ?");
            pst.setString(1, "0");
            pst.setInt(2, course.getModifiedBy());
            pst.setString(3, course.getModifiedDate());
            pst.setInt(4, course.getCourseId());
            pst.setInt(5, course.getCourseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public CourseBean getCourseById(Integer courseId) {
        CourseBean course = null, main_course = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from course where active = ? and course_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, courseId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                course = new CourseBean();
                main_course = new CourseBean();
                main_course.setCourseId(rs.getInt("main_course"));
                course.setCourseId(courseId);
                course.setCourseName(rs.getString("course_title"));
                course.setCourseDuration(rs.getString("duration"));
                course.setMainCourse(main_course);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return course;
    }

    public CourseBean getParentCourse(Integer id) {
        CourseBean mainCourse = new CourseBean();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from course where course_id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mainCourse.setCourseId(id);
                mainCourse.setCourseName(rs.getString("course_title"));
                mainCourse.setCourseDuration(rs.getString("duration"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return mainCourse;
    }

    @Override
    public List<CourseBean> getAllParentCourses() {
        List<CourseBean>parentCourses = new ArrayList<>();
        CourseBean parentCourse  =null;
        try{
                PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from course where main_course is null and active = ?");
                pst.setString(1, "1");
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    parentCourse  = new CourseBean();
                    parentCourse.setCourseId(rs.getInt("course_id"));
                    parentCourse.setCourseName(rs.getString("course_title"));
                    parentCourse.setCourseDuration(rs.getString("duration"));
                    parentCourses.add(parentCourse);
                }
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return parentCourses;
    }
    
    
}
