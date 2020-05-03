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
import beans.BatchBean;
import connection.DBConnection;
import dao.BatchDao;

/**
 *
 * @author Bilal Bhatti
 */
public class BatchDaoImpl implements BatchDao{

    @Override
    public List<BatchBean> getAllBatches() {
        List<BatchBean> batches = new ArrayList<>();
        BatchBean batch = null;
        try{
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from batch where active = ?");
            pst.setString(1,"1");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                batch = new BatchBean();
                batch.setBatchId(rs.getInt("batch_id"));
                batch.setBatchName(rs.getString("batch_title"));
                batches.add(batch);
            }
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return batches;
    }

    @Override
    public int addBatch(BatchBean batch) {
        try{
             PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into batch(batch_title,active,created_by,created_date) values(?,?,?,?)");
             pst.setString(1, batch.getBatchName());
             pst.setString(2, "1");
             pst.setInt(3, batch.getCreatedBy());
             pst.setString(4, batch.getCreatedDate());
             return pst.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public int updateBatch(BatchBean batch) {
        try{
               PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update batch set batch_title=?,modified_by = ?,modified_date = ? where batch_id = ?");
               pst.setString(1, batch.getBatchName());
               pst.setInt(2, batch.getModifiedBy());
               pst.setString(3, batch.getModifiedDate());
               pst.setInt(4, batch.getBatchId());
               return pst.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        
        }
        
        return 0;
    }

    @Override
    public int deleteBatch(BatchBean batch) {
        try{
             PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update batch set active = ?,modified_by = ?,modified_date = ? where batch_id = ?");
             pst.setString(1, "0");
             pst.setInt(2, batch.getModifiedBy());
             pst.setString(3, batch.getModifiedDate());
             pst.setInt(4, batch.getBatchId());
             return pst.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        
        }
                
        return 0;
    }

    @Override
    public BatchBean getBatchById(Integer batchId) {
        BatchBean batch  = null;
        try{
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from batch where active = ? and batch_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, batchId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                batch = new BatchBean();
                batch.setBatchId(batchId);
                batch.setBatchName(rs.getString("batch_title"));
            }
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        
        }
        
        return batch;
    }
    
}
