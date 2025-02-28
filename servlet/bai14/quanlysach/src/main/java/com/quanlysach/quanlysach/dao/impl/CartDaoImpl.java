package com.quanlysach.quanlysach.dao.impl;

import com.quanlysach.quanlysach.dao.ICartDao;
import com.quanlysach.quanlysach.model.CartItemModel;
import com.quanlysach.quanlysach.model.CartModel;
import com.quanlysach.quanlysach.util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class CartDaoImpl implements ICartDao {
    @Override
    public CartModel getCartByUserId(int userId) {
        String query = "SELECT c.id AS cartId, c.userId, c.createdAt, c.updatedAt, " +
                "ci.id AS itemId, ci.productId, ci.quantity, " +
                "ci.createdAt AS itemCreatedAt, ci.updatedAt AS itemUpdatedAt " +
                "FROM cart c " +
                "LEFT JOIN cart_item ci ON c.id = ci.cartId " +
                "WHERE c.userId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                CartModel cartModel = null;
                List<CartItemModel> cartItems = new ArrayList<>();
                while (resultSet.next()) {
                    if (cartModel == null) {
                        cartModel = new CartModel(
                                resultSet.getInt("cartId"),
                                resultSet.getInt("userId"),
                                resultSet.getTimestamp("createdAt"),
                                resultSet.getTimestamp("updatedAt"),
                                cartItems
                        );
                    }

                    Integer itemId = resultSet.getInt("itemId");
                    if (!resultSet.wasNull()) {
                        CartItemModel cartItem = new CartItemModel(
                                itemId,
                                resultSet.getInt("cartId"),
                                resultSet.getInt("productId"),
                                resultSet.getInt("quantity"),
                                resultSet.getTimestamp("itemCreatedAt"),
                                resultSet.getTimestamp("itemUpdatedAt")
                        );
                        cartItems.add(cartItem);
                    }
                }
                return cartModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CartDaoImpl cartDao = new CartDaoImpl();
        CartModel cart = cartDao.getCartByUserId(4);

        if (cart != null) {
            System.out.println("Cart ID: " + cart.getId());
            System.out.println("User ID: " + cart.getUserId());
            System.out.println("Created At: " + cart.getCreatedAt());
            System.out.println("Updated At: " + cart.getUpdatedAt());
            System.out.println("Cart Items:");

            for (CartItemModel item : cart.getCartItems()) {
                System.out.println(" - Item ID: " + item.getId());
                System.out.println("   Product ID: " + item.getProductId());
                System.out.println("   Quantity: " + item.getQuantity());
                System.out.println("   Created At: " + item.getCreatedAt());
                System.out.println("   Updated At: " + item.getUpdatedAt());
            }
        } else {
            System.out.println("Giỏ hàng trống hoặc không tồn tại!");
        }
    }

}