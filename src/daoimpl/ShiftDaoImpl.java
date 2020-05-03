/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ShiftBean;
import connection.DBConnection;
import dao.ShiftDao;

/**
 *
 * @author Bilal Bhatti
 */
public class ShiftDaoImpl implements ShiftDao{

    @Override
    public ResultSet getAllShifts() {
         ResultSet rs=null;

         try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from shift where active = ?");
            pst.setString(1, "1");
            rs = pst.executeQuery();
            
         
            
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
            
        }        
        return rs;       
    }

    @Override
    public int addShift(ShiftBean shift) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(
                    "Insert into shift(shift_title,start_time,end_time,"
                    + "active,created_by,created_date)"                   
                    + "values(?,?,?,?,?,?)");
            
            pst.setString(1, shift.getShiftName());
            pst.setString(2, shift.getStartTime());
            pst.setString(3, shift.getEndTime());
            pst.setString(4, "1");
            pst.setInt(5, shift.getCreatedBy());   
            pst.setString(6, shift.getCreatedDate());
            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;

        
    }

    @Override
    public int updateShift(ShiftBean shift) {
         try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update shift "
                    + "set shift_title =?,start_time =?,end_time =?,"
                    + "modified_by =?,modified_date =? "
                    + "where shift_id =?");

            pst.setString(1, shift.getShiftName());
            pst.setString(2, shift.getStartTime());
            pst.setString(3, shift.getEndTime());
            pst.setInt(4, shift.getModifiedBy());
            pst.setString(5, shift.getModifiedDate());
            pst.setInt(6, shift.getShiftId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    
    }

    @Override
    public int deleteShift(ShiftBean shift) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update shift set active =?,modified_by =?,modified_date =? where shift_id =?");
            pst.setString(1, "0");
            pst.setInt(2, shift.getModifiedBy());
            pst.setString(3, shift.getModifiedDate());
            pst.setInt(4, shift.getShiftId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    
    }

    @Override
    public ShiftBean getShiftById(Integer shiftId) {
        ShiftBean shift = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from shift where active = ? and shift_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, shiftId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                shift = new ShiftBean();

                shift.setShiftId(shiftId);
                shift.setShiftName(rs.getString("shift_title"));
                shift.setStartTime(rs.getString("start_time"));
                shift.setEndTime(rs.getString("end_time"));
                shift.setCreatedBy(rs.getInt("created_by"));
                shift.setCreatedDate(rs.getString("created_date"));
                shift.setModifiedBy(rs.getInt("modified_by"));
                shift.setModifiedDate(rs.getString("modified_date"));

                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return shift;
    
    }
    
}
