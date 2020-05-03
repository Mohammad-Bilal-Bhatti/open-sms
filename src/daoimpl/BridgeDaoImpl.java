/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.BatchBean;
import beans.BridgeBean;
import beans.CourseBean;
import beans.ShiftBean;
import beans.StudentBean;
import connection.DBConnection;
import dao.BridgeDao;

/**
 *
 * @author Bilal Bhatti
 */
public class BridgeDaoImpl implements BridgeDao{

    @Override
    public ResultSet getAllRecords() {
         ResultSet rs=null;

         try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from sbsc_bridge where active = ?");
            pst.setString(1, "1");
            rs = pst.executeQuery();
            

            
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
            
        }        
        return rs;       
    
    }

    @Override
    public int addBridge(BridgeBean bridge) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(
                    "Insert into sbsc_bridge(student_id,batch_id,shift_id,course_id,"
                    + "active,created_by,created_date)"                   
                    + "values(?,?,?,?,?,?,?)");
            
            pst.setInt(1, bridge.getStudent().getStudentId());
            pst.setInt(2, bridge.getBatch().getBatchId());
            pst.setInt(3, bridge.getShift().getShiftId());
            pst.setInt(4, bridge.getCourse().getCourseId());
            pst.setString(5, "1");
            pst.setInt(6, bridge.getCreatedBy());   
            pst.setString(7, bridge.getCreatedDate());
            
            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;

        
    }

    @Override
    public int updateBridge(BridgeBean bridge) {
         try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update sbsc_bridge "
                    + "set student_id =?,batch_id =?,shift_id =?,course_id =?,"
                    + "modified_by =?,modified_date =? "
                    + "where bt_id =?");

            pst.setInt(1, bridge.getStudent().getStudentId());
            pst.setInt(2, bridge.getBatch().getBatchId());
            pst.setInt(3, bridge.getShift().getShiftId());
            pst.setInt(4, bridge.getCourse().getCourseId());
            
            pst.setInt(5, bridge.getModifiedBy());
            pst.setString(6, bridge.getModifiedDate());
            pst.setInt(7, bridge.getBridgeId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
        
    }

    @Override
    public int deleteBridge(BridgeBean bridge) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update sbsc_bridge set active = ?,modified_by = ?,modified_date = ? where bt_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, bridge.getModifiedBy());
            pst.setString(3, bridge.getModifiedDate());
            pst.setInt(4, bridge.getBridgeId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
            return 0;
        }    
    }

    @Override
    public BridgeBean getBridgeById(Integer btId) {
        BridgeBean bridge = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from sbsc_bridge where active = ? and bt_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, btId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bridge = new BridgeBean();
                bridge.setBridgeId(btId);
                System.err.println("BAtch: id: "+rs.getInt("batch_id"));
                BatchBean batch = new BatchDaoImpl().getBatchById(rs.getInt("batch_id"));
                bridge.setBatch(batch);
                
                CourseBean course = new CourseDaoImpl().getCourseById(rs.getInt("course_id"));
                bridge.setCourse(course);
                
                ShiftBean shift = new ShiftDaoImpl().getShiftById(rs.getInt("shift_id"));
                bridge.setShift(shift);
                
                StudentBean student = new StudentDaoImpl().getStudentById(rs.getInt("student_id"));
                bridge.setStudent(student);
                
                bridge.setCreatedBy(rs.getInt("created_by"));
                bridge.setCreatedDate(rs.getString("created_date"));
                bridge.setModifiedBy(rs.getInt("modified_by"));
                bridge.setModifiedDate(rs.getString("modified_date"));

                
            }
        } catch (SQLException ex) {
            System.out.println("exception in bridge dao impl method.");
            System.out.println(ex.getMessage());
        }

        return bridge;
        
    }
    
}
