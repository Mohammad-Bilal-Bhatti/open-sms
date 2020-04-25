/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import beans.ShiftBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface ShiftDao {
    public ResultSet getAllShifts();
    public int addShift(ShiftBean shift);
    public int updateShift(ShiftBean shift);
    public int deleteShift(ShiftBean shift);
    public ShiftBean getShiftById(Integer shiftId);
}
