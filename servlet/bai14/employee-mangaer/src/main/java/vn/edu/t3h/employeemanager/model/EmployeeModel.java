package vn.edu.t3h.employeemanager.model;

public class EmployeeModel {
    private int employeeId;
    private String name;
    private String position;
    private double salary;
    private String departmentName;
    private String hireDate;

    // Constructor, getters, setters
    public Employee() {}

    public Employee(int employeeId, String name, String position, double salary, String departmentName, String hireDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.departmentName = departmentName;
        this.hireDate = hireDate;
    }
    // Getter và Setter

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
