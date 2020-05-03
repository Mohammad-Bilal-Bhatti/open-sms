/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import beans.BridgeBean;
import beans.FeesBean;
import beans.FeesTypeBean;
import connection.DBConnection;
import dao.FeesDao;

/**
 *
 * @author Bilal Bhatti
 */
public class FeesDaoImpl implements FeesDao {

    @Override
    public ResultSet getAllFees() {
        ResultSet rs = null;

        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from fees where active = ?");
            pst.setString(1, "1");
            rs = pst.executeQuery();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();

        }
        return rs;

    }

    @Override
    public int addFees(FeesBean fees) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(
                    "Insert into fees(fee_type_id,bt_id,amount,date_of_paid,no_of_months,"
                    + "active,created_by,created_date)"
                    + "values(?,?,?,?,?,?,?,?)");

            pst.setInt(1, fees.getFeesType().getFeesTypeId());
            pst.setInt(2, fees.getBridgeId().getBridgeId());
            pst.setDouble(3, fees.getFeesAmount());
            pst.setString(4, fees.getDateOfPayment());
            pst.setInt(5, fees.getNumOfMonths());

            pst.setString(6, "1");
            pst.setInt(7, fees.getCreatedBy());
            pst.setString(8, fees.getCreatedDate());
            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;

    }

    @Override
    public int updateFees(FeesBean fees) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update fees "
                    + "set fee_type_id =?,bt_id =?,amount =?,date_of_paid =?,no_of_months =?,"
                    + "modified_by =?,modified_date =? "
                    + "where fees_id =?");
            pst.setInt(1, fees.getFeesType().getFeesTypeId());
            pst.setInt(2, fees.getBridgeId().getBridgeId());
            pst.setDouble(3, fees.getFeesAmount());
            pst.setString(4, fees.getDateOfPayment());
            pst.setInt(5, fees.getNumOfMonths());
            pst.setInt(6, fees.getModifiedBy());
            pst.setString(7, fees.getModifiedDate());
            pst.setInt(8, fees.getFeesId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;

    }

    @Override
    public int deleteFees(FeesBean fees) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update fees set active = ?,modified_by = ?,modified_date = ? where fees_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, fees.getModifiedBy());
            pst.setString(3, fees.getModifiedDate());
            pst.setInt(4, fees.getFeesId());

            return pst.executeUpdate();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;

    }

    @Override
    public FeesBean getFeesById(Integer feesId) {
        FeesBean fees = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from fees where active = ? and fees_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, feesId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fees = new FeesBean();

                fees.setFeesId(feesId);

                FeesTypeBean feesType = new FeesTypeBean();
                int type_id = rs.getInt("fee_type_id");

                feesType = new FeeTypeDaoImpl().getFeesById(type_id);
                fees.setFeesType(feesType);

                BridgeBean bridge = new BridgeDaoImpl().getBridgeById(rs.getInt("bt_id"));
                fees.setBridgeId(bridge);

                fees.setFeesAmount(rs.getDouble("amount"));
                fees.setDateOfPayment(rs.getString("date_of_paid"));
                fees.setNumOfMonths(rs.getInt("no_of_months"));
                fees.setCreatedBy(rs.getInt("created_by"));
                fees.setCreatedDate(rs.getString("created_date"));
                fees.setModifiedBy(rs.getInt("modified_by"));
                fees.setModifiedDate(rs.getString("modified_date"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return fees;

    }

    @Override
    public ResultSet getRecordForReport(Integer bt_id, String dateOfPayment) {
        String query = "select date_of_paid,fee_type_id,SUM(amount) as sum "
                + "from fees "
                + "where active = ? and bt_id = ? and date_of_paid = ? "
                + "GROUP BY fee_type_Id;";
        ResultSet rs = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
            pst.setString(1, "1");
            pst.setInt(2, bt_id);
            pst.setString(3, dateOfPayment);

            rs = pst.executeQuery();

        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return rs;

    }

    @Override
    public List<FeesBean> getFeesRecord(String month, Integer year) {
        List<FeesBean> feesRecord = new ArrayList<>();
        FeesBean fees = null;
        FeesTypeBean feeType = null;
        String year1 = String.valueOf(year);
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select ft.fee_title, sum(f.amount)as 'Total Fees' from fees f inner join fee_type ft on\n"
                    + "f.fee_type_id=ft.fee_type_id  where f.date_of_paid like '%" + month + " " + year1 + "'  and f.active=1\n"
                    + " group by f.fee_type_id,f.date_of_paid");
            while (rs.next()) {
                fees = new FeesBean();
                feeType = new FeesTypeBean();
                feeType.setFeesTitle(rs.getString("fee_title"));
                fees.setTotalFeesAmount(rs.getDouble("Total Fees"));
                fees.setFeesType(feeType);
                feesRecord.add(fees);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return feesRecord;
    }

}
