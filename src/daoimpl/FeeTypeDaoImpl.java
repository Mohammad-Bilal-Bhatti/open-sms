/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.FeesTypeBean;
import connection.DBConnection;
import dao.FeeTypeDao;

/**
 *
 * @author Bilal Bhatti
 */
public class FeeTypeDaoImpl implements FeeTypeDao {

    @Override
    public ResultSet getAllFeeTypes() {
         ResultSet rs=null;
    //    FeesTypeBean type;
    //    ArrayList<FeesTypeBean> types=new ArrayList<FeesTypeBean>();
         try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from fee_type where active = ?");
            pst.setString(1, "1");
            rs = pst.executeQuery();
           
            
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }        
        return rs;       
        
    }

    @Override
    public int addFees(FeesTypeBean type) {
         try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(
                    "Insert into fee_type(fee_title,"
                    + "active,created_by,created_date)"                   
                    + "values(?,?,?,?)");
            
            pst.setString(1, type.getFeesTitle());
            pst.setString(2, "1");
            pst.setInt(3, type.getCreatedBy());   
            pst.setString(4, type.getCreatedDate());
            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
       
    }

    @Override
    public int updateFees(FeesTypeBean type) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update fee_type "
                    + "set fee_title =?,"
                    + "modified_by =?,modified_date =? "
                    + "where fee_type_id =?");

            pst.setString(1, type.getFeesTitle());
            pst.setInt(2, type.getModifiedBy());
            pst.setString(3, type.getModifiedDate());
            pst.setInt(4, type.getFeesTypeId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    
       
    }

    @Override
    public int deleteFees(FeesTypeBean type) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update fee_type set active = ?,modified_by = ?,modified_date = ? where fee_type_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, type.getModifiedBy());
            pst.setString(3, type.getModifiedDate());
            pst.setInt(4, type.getFeesTypeId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
         
    }

    @Override
    public FeesTypeBean getFeesById(Integer feeTypeId) {
        
        FeesTypeBean feesType=null;

        try{
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from fee_type where active = ? and fee_type_id = ?");
            pst.setString(1,"1");
            pst.setInt(2, feeTypeId);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                feesType=new FeesTypeBean();
                feesType.setFeesTypeId(rs.getInt("fee_type_id"));
                feesType.setFeesTitle(rs.getString("fee_title"));
                feesType.setCreatedBy(rs.getInt("created_by"));
                feesType.setCreatedDate(rs.getString("created_date"));
                feesType.setModifiedBy(rs.getInt("modified_by"));
                feesType.setModifiedDate(rs.getString("modified_date"));
            }
        }catch(SQLException se){
            System.err.println(se.getMessage());
            se.printStackTrace();
        
        }
        
        return feesType;
    }
    
}
