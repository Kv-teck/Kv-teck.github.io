package vn.edu.t3h.employeemanager.dao.impl;

import vn.edu.t3h.employeemanager.dao.EmployeeDAO;
import vn.edu.t3h.employeemanager.model.EmployeeModel;
import vn.edu.t3h.employeemanager.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String SELECT_ALL = "SELECT * FROM employees";
    private static final String SELECT_BY_ID = "SELECT * FROM employees WHERE id = ?";
    private static final String SEARCH_EMPLOYEES = "SELECT * FROM employees WHERE name LIKE ?";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees (name, department) VALUES (?, ?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE id = ?";

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                employees.add(new EmployeeModel(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public EmployeeModel getEmployeeById(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new EmployeeModel(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeeModel> searchEmployees(String keyword) {
        List<EmployeeModel> employees = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SEARCH_EMPLOYEES)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(new EmployeeModel(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void addEmployee(EmployeeModel employee) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_EMPLOYEE)) {
            stmt.setString(1, employee.getName());
//            stmt.setString(2, employee.getDepartment());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(EmployeeModel employee) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_EMPLOYEE)) {
            stmt.setString(1, employee.getName());
//            stmt.setString(2, employee.getDepartment());
            stmt.setInt(3, employee.getEmployeeId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_EMPLOYEE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
