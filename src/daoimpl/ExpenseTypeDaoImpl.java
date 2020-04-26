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
import beans.ExpenseTypeBean;
import connection.DBConnection;
import dao.ExpenseTypeDao;

/**
 *
 * @author Bilal Bhatti
 */
public class ExpenseTypeDaoImpl implements ExpenseTypeDao {

    @Override
    public List<ExpenseTypeBean> getAllExpenseTypes() {
        List<ExpenseTypeBean> expenseTypes = new ArrayList<>();
        ExpenseTypeBean expense = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense_type where active = ?");
            pst.setString(1, "1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                expense = new ExpenseTypeBean();
                expense.setExpenseTypeId(rs.getInt("exp_type_id"));
                expense.setExpenseTitle(rs.getString("exp_type_title"));
                expenseTypes.add(expense);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return expenseTypes;
    }

    @Override
    public int addExpenseType(ExpenseTypeBean expenseType) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into expense_type(exp_type_title,active,created_by,created_date) values(?,?,?,?)");
            pst.setString(1, expenseType.getExpenseTitle());
            pst.setString(2, "1");
            pst.setInt(3, expenseType.getCreatedBy());
            pst.setString(4, expenseType.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateExpenseType(ExpenseTypeBean expenseType) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense_type set exp_type_title = ?,modified_by = ?,modified_date = ? where exp_type_id = ?");
            pst.setString(1, expenseType.getExpenseTitle());
            pst.setInt(2, expenseType.getModifiedBy());
            pst.setString(3, expenseType.getModifiedDate());
            pst.setInt(4, expenseType.getExpenseTypeId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteExpenseType(ExpenseTypeBean expenseType) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense_type set active = ?,modified_by = ?,modified_date = ? where exp_type_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, expenseType.getModifiedBy());
            pst.setString(3, expenseType.getModifiedDate());
            pst.setInt(4, expenseType.getExpenseTypeId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public ExpenseTypeBean getExpenseTypeById(Integer expenseTypeId) {
        ExpenseTypeBean expenseType = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense_type where active = ? and exp_type_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, expenseTypeId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                expenseType = new ExpenseTypeBean();
                expenseType.setExpenseTypeId(expenseTypeId);
                expenseType.setExpenseTitle(rs.getString("exp_type_title"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return expenseType;
    }

    @Override
    public ExpenseTypeBean getExpenseTypeByName(String expenseType) {
        ExpenseTypeBean expenseTypeBean = new ExpenseTypeBean();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense_type where active = ? and exp_type_title = ?");
            pst.setString(1, "1");
            pst.setString(2, expenseType);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                expenseTypeBean.setExpenseTypeId(rs.getInt("exp_type_id"));
                expenseTypeBean.setExpenseTitle(expenseType);
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return expenseTypeBean;
    }

}
