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
import beans.EmployeeBean;
import beans.ExpenseBean;
import beans.ExpenseTypeBean;
import connection.DBConnection;
import dao.EmployeeDao;
import dao.ExpenseDao;
import dao.ExpenseTypeDao;
import utility.DateFormatter;

/**
 *
 * @author Javed Ali Dahri
 */
public class ExpenseDaoImpl implements ExpenseDao {

    @Override
    public List<ExpenseBean> getAllExpenses() {
        List<ExpenseBean> expenses = new ArrayList<>();
        ExpenseBean expense = null;
        EmployeeBean employee = null;
        ExpenseTypeBean expenseTypeBean = null;
        ExpenseTypeDao expenseTypeDao = new ExpenseTypeDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * where active = ?");
            pst.setString(1, "1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                expense = new ExpenseBean();
                employee = new EmployeeBean();
                expenseTypeBean = new ExpenseTypeBean();

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }

        return null;
    }

    public int addExpense(ExpenseBean expense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into expense(exp_type_id,emp_id,amount,date_of_payment,active,created_by,created_date) values(?,?,?,?,?,?,?)");
            pst.setInt(1, expense.getExpenseType().getExpenseTypeId());
            if (expense.getEmployee().getEmpId() == 0) {
                pst.setString(2, null);
            } else {
                pst.setInt(2, expense.getEmployee().getEmpId());
            }
            pst.setInt(3, Integer.parseInt(expense.getExpenseAmount() + ""));
            pst.setString(4, expense.getDateOfPayment());
            pst.setString(5, "1");
            pst.setInt(6, expense.getCreatedBy());
            pst.setString(7, expense.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }

        return 0;
    }

    public int updateExpense(ExpenseBean expense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense set exp_type_id = ?,emp_id = ?,amount = ?,date_of_payment = ?,modified_by = ?,modified_date = ? where expense_id = ?");
            pst.setInt(1, expense.getExpenseType().getExpenseTypeId());
            if (expense.getEmployee().getEmpId() == 0) {
                pst.setString(2, null);
            } else {
                pst.setInt(2, expense.getEmployee().getEmpId());
            }
            pst.setInt(3, Integer.parseInt(expense.getExpenseAmount() + ""));
            pst.setString(4, expense.getDateOfPayment());
            pst.setInt(5, expense.getModifiedBy());
            pst.setString(6, expense.getModifiedDate());
            pst.setInt(7, expense.getExpenseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }

        return 0;
    }

    @Override
    public int deleteExpense(ExpenseBean expense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense set active = ?, modified_by = ?,modified_date = ? where expense_id = ?");
            pst.setString(1, "0");
            pst.setInt(2, expense.getModifiedBy());
            pst.setString(3, expense.getModifiedDate());
            pst.setInt(4, expense.getExpenseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public ExpenseBean getExpenseById(Integer expenseId) {
        ExpenseBean expense = null;
        ExpenseTypeBean type = null;
        EmployeeBean emp = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense where active = ? and expense_id = ?");
            pst.setString(1, "1");
            pst.setInt(2, expenseId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                expense = new ExpenseBean();
                type = new ExpenseTypeBean();
                emp = new EmployeeBean();
                expense.setExpenseId(expenseId);
                type.setExpenseTypeId(rs.getInt("exp_type_id"));
                emp.setEmpId(rs.getInt("emp_id"));
                expense.setExpenseAmount(rs.getDouble("amount"));
                expense.setDateOfPayment(rs.getString("date_of_payment"));
                expense.setEmployee(emp);
                expense.setExpenseType(type);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }

        return expense;
    }

    @Override
    public List<ExpenseBean> getAllDailyExpenses() {
        List<ExpenseBean> dailyExpenses = new ArrayList<>();
        ExpenseBean dailyExpense = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense where active = ? and status = ?");
            pst.setString(1, "1");
            pst.setString(2, "daily");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dailyExpense = new ExpenseBean();
                dailyExpense.setExpenseId(rs.getInt("expense_id"));
                dailyExpense.setExpenseTitle(rs.getString("expense_title"));
                dailyExpense.setExpenseAmount(rs.getDouble("amount"));
                dailyExpense.setDateOfPayment(rs.getString("date_of_payment"));
                dailyExpenses.add(dailyExpense);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return dailyExpenses;
    }

    @Override
    public List<ExpenseBean> getAllMonthlyExpenses() {
        List<ExpenseBean> monthlyExpenses = new ArrayList<>();
        ExpenseTypeDao expenseTypeDao = new ExpenseTypeDaoImpl();
        ExpenseBean monthlyExpense = null;
        EmployeeBean employee = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select e.expense_id,e.exp_type_id,e.amount,e.date_of_payment,emp.emp_id,emp.emp_name from expense e Left Join employee emp on e.emp_id=emp.emp_id where e.status=? and e.active=?");
            pst.setString(1, "monthly");
            pst.setString(2, "1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                monthlyExpense = new ExpenseBean();
                monthlyExpense.setExpenseId(rs.getInt("expense_id"));
                monthlyExpense.setExpenseType(expenseTypeDao.getExpenseTypeById(rs.getInt("exp_type_id")));
                monthlyExpense.setExpenseAmount(rs.getDouble("amount"));
                monthlyExpense.setDateOfPayment(rs.getString("date_of_payment"));
                employee = new EmployeeBean();
                employee.setEmpId(rs.getInt("emp_id"));
                if (rs.getInt("emp_id") == 0) {
                    employee.setEmpName(" ");
                } else {
                    employee.setEmpName(rs.getString("emp_name"));
                }
                monthlyExpense.setEmployee(employee);
                monthlyExpenses.add(monthlyExpense);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return monthlyExpenses;
    }

    @Override
    public List<ExpenseBean> getAllOwnerExpenses() {
        List<ExpenseBean> ownerExpenses = new ArrayList<>();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        ExpenseBean ownerExpense = null;
        EmployeeBean owner = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select e.expense_id,emp.emp_id,emp.emp_name,e.amount,e.date_of_payment from expense e inner join employee emp on e.emp_id=emp.emp_id where e.active=? and e.status=?");
            pst.setString(1, "1");
            pst.setString(2, "owner");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ownerExpense = new ExpenseBean();
                owner = new EmployeeBean();
                ownerExpense.setExpenseId(rs.getInt("expense_id"));
                ownerExpense.setExpenseAmount(rs.getDouble("amount"));
                ownerExpense.setDateOfPayment(rs.getString("date_of_payment"));
                owner.setEmpId(rs.getInt("emp_id"));
                owner.setEmpName(rs.getString("emp_name"));
                ownerExpense.setEmployee(owner);
                ownerExpenses.add(ownerExpense);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return ownerExpenses;
    }

    @Override
    public int addDailyExpense(ExpenseBean dailyExpense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into expense(expense_title,amount,status,date_of_payment,active,created_by,created_date)values(?,?,?,?,?,?,?)");
            pst.setString(1, dailyExpense.getExpenseTitle());
            pst.setDouble(2, dailyExpense.getExpenseAmount());
            pst.setString(3, "daily");
            pst.setString(4, dailyExpense.getDateOfPayment());
            pst.setString(5, "1");
            pst.setInt(6, dailyExpense.getCreatedBy());
            pst.setString(7, dailyExpense.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public int addMonthlyExpense(ExpenseBean monthlyExpense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into expense(exp_type_id,emp_id,amount,status,date_of_payment,active,created_by,created_date)values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, monthlyExpense.getExpenseType().getExpenseTypeId());
            if (monthlyExpense.getEmployee().getEmpId() != 0) {
                pst.setInt(2, monthlyExpense.getEmployee().getEmpId());
            } else {
                pst.setString(2, null);
            }
            pst.setDouble(3, monthlyExpense.getExpenseAmount());
            pst.setString(4, "monthly");
            pst.setString(5, monthlyExpense.getDateOfPayment());
            pst.setString(6, "1");
            pst.setInt(7, monthlyExpense.getCreatedBy());
            pst.setString(8, monthlyExpense.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public int addOwnerExpense(ExpenseBean ownerExpense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Insert into expense(emp_id,amount,date_of_payment,status,active,created_by,created_date)values(?,?,?,?,?,?,?)");
            pst.setInt(1, ownerExpense.getEmployee().getEmpId());
            pst.setDouble(2, ownerExpense.getExpenseAmount());
            pst.setString(3, ownerExpense.getDateOfPayment());
            pst.setString(4, "owner");
            pst.setString(5, "1");
            pst.setInt(6, ownerExpense.getCreatedBy());
            pst.setString(7, ownerExpense.getCreatedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public int updateDailyExpense(ExpenseBean dailyExpense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense set expense_title=?,amount =?,date_of_payment=?,modified_by=?,modified_date=? where expense_id=?");
            pst.setString(1, dailyExpense.getExpenseTitle());
            pst.setDouble(2, dailyExpense.getExpenseAmount());
            pst.setString(3, dailyExpense.getDateOfPayment());
            pst.setInt(4, dailyExpense.getModifiedBy());
            pst.setString(5, dailyExpense.getModifiedDate());
            pst.setInt(6, dailyExpense.getExpenseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public int updateMonthlyExpense(ExpenseBean monthlyExpense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense set exp_type_id=?,emp_id=?,amount=?,date_of_payment=?,modified_by=?,modified_date=? where expense_id= ?");
            pst.setInt(1, monthlyExpense.getExpenseType().getExpenseTypeId());
            if (monthlyExpense.getEmployee().getEmpId() != 0) {
                pst.setInt(2, monthlyExpense.getEmployee().getEmpId());
            } else {
                pst.setString(2, null);
            }
            pst.setDouble(3, monthlyExpense.getExpenseAmount());
            pst.setString(4, monthlyExpense.getDateOfPayment());
            pst.setInt(5, monthlyExpense.getModifiedBy());
            pst.setString(6, monthlyExpense.getModifiedDate());
            pst.setInt(7, monthlyExpense.getExpenseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public int updateOwnerExpense(ExpenseBean ownerExpense) {
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Update expense set emp_id=?,amount=?,date_of_payment=?,modified_by=?,modified_date=? where expense_id = ?");
            pst.setInt(1, ownerExpense.getEmployee().getEmpId());
            pst.setDouble(2, ownerExpense.getExpenseAmount());
            pst.setString(3, ownerExpense.getDateOfPayment());
            pst.setInt(4, ownerExpense.getModifiedBy());
            pst.setString(5, ownerExpense.getModifiedDate());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return 0;
    }

    @Override
    public ExpenseBean getDailyExpenseById(Integer dailyExpenseId) {
        ExpenseBean dailyExpense = new ExpenseBean();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense where expense_id=?");
            pst.setInt(1, dailyExpenseId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dailyExpense.setExpenseId(dailyExpenseId);
                dailyExpense.setExpenseTitle(rs.getString("expense_title"));
                dailyExpense.setExpenseAmount(rs.getDouble("amount"));
                dailyExpense.setDateOfPayment(rs.getString("date_of_payment"));
                break;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return dailyExpense;
    }

    @Override
    public ExpenseBean getMonthlyExpenseId(Integer monthlyExpenseId) {
        ExpenseBean monthlyExpense = new ExpenseBean();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense where expense_id=?");
            pst.setInt(1, monthlyExpenseId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                monthlyExpense.setExpenseId(monthlyExpenseId);
                monthlyExpense.setExpenseTitle(rs.getString("expense_title"));
                monthlyExpense.setExpenseAmount(rs.getDouble("amount"));
                monthlyExpense.setDateOfPayment(DateFormatter.formatDate(rs.getDate("date_of_payment")));
                break;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return monthlyExpense;
    }

    @Override
    public ExpenseBean getOwnerExpenseId(Integer ownerExpenseId) {
        ExpenseBean ownerExpense = new ExpenseBean();
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement("Select * from expense where expense_id=?");
            pst.setInt(1, ownerExpenseId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ownerExpense.setExpenseId(ownerExpenseId);
                ownerExpense.setExpenseTitle(rs.getString("expense_title"));
                ownerExpense.setExpenseAmount(rs.getDouble("amount"));
                ownerExpense.setDateOfPayment(DateFormatter.formatDate(rs.getDate("date_of_payment")));
                break;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        }
        return ownerExpense;
    }

    @Override
    public ResultSet getForAnalytics(int month, int year) {
        //Start from first day of the month...
        String startDay = "01";
        String endDay = "31";

        String monthString = (month < 10) ? "0" + month : month + "";

        //start form start date...
        String startDate = year + "-" + monthString + "-" + startDay;
        //End to last date of month...
        String endDate = year + "-" + monthString + "-" + endDay;

        String query = "select exp_type_id, sum(amount) as total,date_of_payment "
                + "from expense "
                + "where active = ? and (date(date_of_payment) between "
                + "date(?) and date(?) ) "
                + "group by exp_type_id";
        ResultSet rs = null;
        try {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
            pst.setString(1, "1");
            pst.setString(2, startDate);
            pst.setString(3, endDate);

            return rs = pst.executeQuery();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            sqle.printStackTrace();
        }

        return rs;
    }

}
