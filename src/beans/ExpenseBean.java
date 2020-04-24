/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Javed Ali Dahri
 */
public class ExpenseBean extends Bean implements Serializable{
    
    public ExpenseBean(){}
    
    private Integer expenseId;
    private ExpenseTypeBean expenseType;
    private EmployeeBean employee;
    private Double expenseAmount;
    private String dateOfPayment;
    private String status;
    private String expenseTitle;
    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public ExpenseTypeBean getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseTypeBean expenseType) {
        this.expenseType = expenseType;
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }
}
