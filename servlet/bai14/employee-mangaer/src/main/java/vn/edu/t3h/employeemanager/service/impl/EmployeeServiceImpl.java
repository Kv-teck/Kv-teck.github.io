package vn.edu.t3h.employeemanager.service.impl;

import vn.edu.t3h.employeemanager.dao.EmployeeDAO;
import vn.edu.t3h.employeemanager.dao.impl.EmployeeDAOImpl;
import vn.edu.t3h.employeemanager.model.EmployeeModel;
import vn.edu.t3h.employeemanager.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public EmployeeModel getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void addEmployee(EmployeeModel employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(EmployeeModel employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
