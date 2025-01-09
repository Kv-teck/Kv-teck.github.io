package exercise.Module2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
//    Tài Khoản

    private String accountNumber;
    private String accountHolder;
    private Double balance;
    private Employee employeeInCharge;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Đã nạp " + amount + " vào tài khoản " + accountNumber);
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Đã rút " + amount + " từ tài khoản " + accountNumber);
            return true;
        } else {
            System.out.println("Số dư không đủ hoặc số tiền rút không hợp lệ.");
            return false;
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void enterInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên chủ tài khoản: ");
        this.accountHolder = sc.nextLine();
        System.out.println("Nhập số dư ban đầu: ");
        this.balance = sc.nextDouble();
        sc.nextLine();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setEmployeeInCharge(Employee employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
