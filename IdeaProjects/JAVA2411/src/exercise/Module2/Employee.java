package exercise.Module2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
//    Nhân Viên

    private String id;
    private String name;
    private Double salary;
    private List<Account> managedAccounts = new ArrayList<>();

    public void showInfo() {
        System.out.println(this.toString());
    }

    public void enterInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên: ");
        this.name = sc.nextLine();
        System.out.println("Nhập Lương nhân viên: ");
        this.salary = sc.nextDouble();
    }

    @Override
    public String toString(){
        return "Mã nhân viên "+ id + " Tên nhân viên " + name + " Lương nhân viên " + salary;
    }

    public void processTransaction(Transaction transaction) {

    }

//    public double calculateBonus()

    public void addAccount(Account account) {
        managedAccounts.add(account);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public List<Account> getManagedAccounts() {
        return managedAccounts;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setManagedAccounts(List<Account> managedAccounts) {
        this.managedAccounts = managedAccounts;
    }
}
