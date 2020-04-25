/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import beans.FeesTypeBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface FeeTypeDao {
    public ResultSet getAllFeeTypes();
    public int addFees(FeesTypeBean type);
    public int updateFees(FeesTypeBean type);
    public int deleteFees(FeesTypeBean type);
    public FeesTypeBean getFeesById(Integer feeTypeId);
}
