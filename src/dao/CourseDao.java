/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import beans.CourseBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface CourseDao {
    public List<CourseBean> getAllCourses();
    public int addCourse(CourseBean course);
    public int updateCourse(CourseBean course);
    public int deleteCourse(CourseBean course);
    public CourseBean getCourseById(Integer courseId);
    public List<CourseBean>getAllParentCourses();
}
