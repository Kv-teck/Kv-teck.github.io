package vn.edu.t3h.employeemanager.service;

import vn.edu.t3h.employeemanager.model.EmployeeModel;
import java.util.List;

public interface EmployeeService {
    List<EmployeeModel> getAllEmployees();
    EmployeeModel getEmployeeById(int id);
    void addEmployee(EmployeeModel employee);
    void updateEmployee(EmployeeModel employee);
    void deleteEmployee(int id);
}
