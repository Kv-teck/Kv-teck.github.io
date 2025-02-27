package com.quanlysach.quanlysach.dao.impl;

import com.quanlysach.quanlysach.dao.ICategoryDao;
import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public CategoryModel getCategoryById(String categoryId) {
        CategoryModel categoryModel = new CategoryModel();
        String query = "select c.id,c.name from category c where id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
             statement.setString(1, categoryId);
             ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                categoryModel.setId(resultSet.getInt("id"));
                categoryModel.setname(resultSet.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryModel;
    }

    @Override
    public List<CategoryModel> getAllCategory() {
        List<CategoryModel> categoryModels = new ArrayList<>();
        String query = "select c.id,c.name,c.description,c.imageName from category c";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CategoryModel categoryModel = new CategoryModel();

                categoryModel.setId(resultSet.getInt("id"));
                categoryModel.setname(resultSet.getString("name"));
                categoryModel.setDescription(resultSet.getString("description"));
                categoryModel.setImageName(resultSet.getString("imageName"));
                categoryModels.add(categoryModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryModels;
    }

}
