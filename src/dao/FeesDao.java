/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import beans.FeesBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface FeesDao {
    public ResultSet getAllFees();
    public int addFees(FeesBean fee);
    public int updateFees(FeesBean fee);
    public int deleteFees(FeesBean fee);
    public FeesBean getFeesById(Integer feesId);
    public ResultSet getRecordForReport(Integer bt_id,String dateOfPayment);
    public List<FeesBean> getFeesRecord(String month,Integer year);
}
