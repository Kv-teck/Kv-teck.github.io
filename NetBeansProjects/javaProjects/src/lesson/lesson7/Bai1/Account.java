/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lesson.lesson7.Bai1;

import java.util.Date;

/**
 *
 * @author khiet
 */
public class Account {
    int id;// id tài khoản mặc định = 0
    double balance;// só dư tài khoản mặc định =0
    double annualInterestRate;// Lãi suất lãi hàng năm mặc định  = 0
    Date dateCreated;// Ngày tạo tài khoản mặc định là ngày hiện tại

    public void getMonthlyInterestRate(){
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}
