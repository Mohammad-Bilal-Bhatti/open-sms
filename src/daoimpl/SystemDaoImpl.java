/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import connection.DBConnection;
import dao.SystemDao;
import utility.DateFormatter;

/**
 *
 * @author Javed Ali Dahri
 */
public class SystemDaoImpl implements SystemDao{

    @Override
    public boolean checkMacAddress(String macAddress) {
        try{
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select mac_address from system where mac_address = ?");
            pst.setString(1,macAddress);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int insertMacAddress(String macAddress) {
       try{
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into system(mac_address,date) values(?,?)");
            pst.setString(1,macAddress);
            pst.setString(2,DateFormatter.formatDate(new Date()));
            return pst.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
       return 0;
    }  
}
