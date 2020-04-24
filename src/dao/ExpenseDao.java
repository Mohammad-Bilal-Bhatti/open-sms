/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import beans.ExpenseBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface ExpenseDao {
    public List<ExpenseBean> getAllExpenses();
    public List<ExpenseBean> getAllDailyExpenses();
    public List<ExpenseBean> getAllMonthlyExpenses();
    public List<ExpenseBean> getAllOwnerExpenses();
    public int addDailyExpense(ExpenseBean dailyExpense);
    public int addMonthlyExpense(ExpenseBean monthlyExpense);
    public int addOwnerExpense(ExpenseBean ownerExpense);
    //public int addExpense(ExpenseBean expense);
    public int updateDailyExpense(ExpenseBean dailyExpense);
    public int updateMonthlyExpense(ExpenseBean monthlyExpense);
    public int updateOwnerExpense(ExpenseBean ownerExpense);
    //public int updateExpense(ExpenseBean expense);
    public int deleteExpense(ExpenseBean expense);
    public ExpenseBean getExpenseById(Integer expenseId);
    public ExpenseBean getDailyExpenseById(Integer dailyExpenseId);
    public ExpenseBean getMonthlyExpenseId(Integer monthlyExpenseId);
    public ExpenseBean getOwnerExpenseId(Integer ownerExpenseId);
    public ResultSet getForAnalytics(int month,int year);
}
