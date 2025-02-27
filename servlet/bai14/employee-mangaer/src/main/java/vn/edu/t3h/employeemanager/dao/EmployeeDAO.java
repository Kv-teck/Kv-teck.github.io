package vn.edu.t3h.employeemanager.dao;

import vn.edu.t3h.employeemanager.model.EmployeeModel;
import java.util.List;

public interface EmployeeDAO {
    List<EmployeeModel> getAllEmployees();
    EmployeeModel getEmployeeById(int id);
    List<EmployeeModel> searchEmployees(String keyword);
    void addEmployee(EmployeeModel employee);
    void updateEmployee(EmployeeModel employee);
    void deleteEmployee(int id);
}
