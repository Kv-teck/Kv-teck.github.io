package com.quanlysach.quanlysach.dao.impl;

import com.quanlysach.quanlysach.dao.IProductDao;
import com.quanlysach.quanlysach.model.ProductModel;
import com.quanlysach.quanlysach.util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class ProductDaoImpl implements IProductDao {
    @Override
    public ProductModel getProductById(String productId) {
        ProductModel productModel = new ProductModel();
        String query = "SELECT * FROM product WHERE id = ?; ";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                productModel.setId(resultSet.getInt("id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setPrice(resultSet.getDouble("price"));
                productModel.setDiscount(resultSet.getInt("discount"));
                productModel.setQuantity(resultSet.getInt("quantity"));
                productModel.setTotalBuy(resultSet.getInt("totalBuy"));
                productModel.setAuthor(resultSet.getString("author"));
                productModel.setPages(resultSet.getInt("pages"));
                productModel.setPublisher(resultSet.getString("publisher"));
                productModel.setYearPublishing(resultSet.getInt("yearPublishing"));
                productModel.setDescription(resultSet.getString("description"));
                productModel.setImageName(resultSet.getString("imageName"));
                productModel.setShop(resultSet.getBoolean("shop"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productModel;
    }

    @Override
    public List<ProductModel> getProductByCategory(String category) {
        List<ProductModel> productModels = new ArrayList<>();
        String query = "SELECT categoryId, p.*\n" +
                "FROM product p\n" +
                "JOIN product_category pc ON p.id = pc.productId\n" +
                "WHERE pc.categoryId = ?;";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProductModel productModel = new ProductModel();

                productModel.setId(resultSet.getInt("id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setPrice(resultSet.getDouble("price"));
                productModel.setDiscount(resultSet.getInt("discount"));
                productModel.setQuantity(resultSet.getInt("quantity"));
                productModel.setTotalBuy(resultSet.getInt("totalBuy"));
                productModel.setAuthor(resultSet.getString("author"));
                productModel.setPages(resultSet.getInt("pages"));
                productModel.setPublisher(resultSet.getString("publisher"));
                productModel.setYearPublishing(resultSet.getInt("yearPublishing"));
                productModel.setDescription(resultSet.getString("description"));
                productModel.setImageName(resultSet.getString("imageName"));
                productModel.setShop(resultSet.getBoolean("shop"));

                productModels.add(productModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productModels;
    }

    @Override
    public List<ProductModel> getAllProduct() {
        List<ProductModel> productModels = new ArrayList<>();
        String query = "select p.id, p.name, p.price, p.discount, p.quantity, p.totalBuy, p.author,p.pages,p.publisher,p.yearPublishing,p.description,p.imageName,p.shop " +
                "from product p";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ProductModel productModel = new ProductModel();

                productModel.setId(resultSet.getInt("id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setPrice(resultSet.getDouble("price"));
                productModel.setDiscount(resultSet.getInt("discount"));
                productModel.setQuantity(resultSet.getInt("quantity"));
                productModel.setTotalBuy(resultSet.getInt("totalBuy"));
                productModel.setAuthor(resultSet.getString("author"));
                productModel.setPages(resultSet.getInt("pages"));
                productModel.setPublisher(resultSet.getString("publisher"));
                productModel.setYearPublishing(resultSet.getInt("yearPublishing"));
                productModel.setDescription(resultSet.getString("description"));
                productModel.setImageName(resultSet.getString("imageName"));
                productModel.setShop(resultSet.getBoolean("shop"));

                productModels.add(productModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productModels;
    }

}
