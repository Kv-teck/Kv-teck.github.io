package exercise.Module2;


import java.time.LocalDateTime;

public class Transaction {
//    Giao Dịch

    private String transactionId;
    private Account account;
    private Employee employee;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;

    public Transaction(String transactionId, Account account, Employee employee, String type, Double amount, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.account = account;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public void showInfo() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + "\n" +
                "Account: " + account.getAccountNumber() + " (" + account.getAccountHolder() + ")\n" +
                "Employee: " + employee.getName() + "\n" +
                "Type: " + type + "\n" +
                "Amount: " + amount + "\n" +
                "Timestamp: " + timestamp;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
