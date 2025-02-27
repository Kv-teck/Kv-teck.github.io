package com.quanlysach.quanlysach.dao.impl;

import com.quanlysach.quanlysach.dao.IUserDao;
import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.util.DatabaseConnection;

import java.sql.*;

public class UserDaoImpl implements IUserDao {
    @Override
    public UserModel findUserByRoleId(String roleId) {
        UserModel userModel = null;
        String query = "select * from user where role = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roleId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String userName = resultSet.getString("username");
                    String passWord = resultSet.getString("password");
                    String fullName = resultSet.getString("fullName");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Boolean gender = resultSet.getBoolean("gender");
                    String address = resultSet.getString("address");
                    String role = resultSet.getString("role");
                    userModel = new UserModel(id, userName, passWord, fullName, email, phoneNumber, gender, address, role);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userModel;
    }

    @Override
    public UserModel findUserByUserNameAndPassword(String username, String password) {
        UserModel userModel = null;
        String query = "select * from user where username = ? and password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String userName = resultSet.getString("username");
                    String passWord = resultSet.getString("password");
                    String fullName = resultSet.getString("fullName");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Boolean gender = resultSet.getBoolean("gender");
                    String address = resultSet.getString("address");
                    String role = resultSet.getString("role");
                    userModel = new UserModel(id, userName, passWord, fullName, email, phoneNumber, gender, address, role);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userModel;
    }
}
