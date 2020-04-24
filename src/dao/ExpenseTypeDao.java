/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import beans.ExpenseTypeBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface ExpenseTypeDao {
    public List<ExpenseTypeBean> getAllExpenseTypes();
    public int addExpenseType(ExpenseTypeBean expenseType);
    public int updateExpenseType(ExpenseTypeBean expenseType);
    public int deleteExpenseType(ExpenseTypeBean expenseType);
    public ExpenseTypeBean getExpenseTypeById(Integer expenseTypeId);
    public ExpenseTypeBean getExpenseTypeByName(String expenseType);
}
