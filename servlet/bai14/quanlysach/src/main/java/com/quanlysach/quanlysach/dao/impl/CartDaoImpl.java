package com.quanlysach.quanlysach.dao.impl;

import com.quanlysach.quanlysach.dao.ICartDao;
import com.quanlysach.quanlysach.model.CartItemModel;
import com.quanlysach.quanlysach.model.CartModel;
import com.quanlysach.quanlysach.model.ProductModel;
import com.quanlysach.quanlysach.util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class CartDaoImpl implements ICartDao {
    @Override
    public CartModel getCartByUserId(int userId) {
        String query = "SELECT\n" +
                "    c.id AS cart_id,\n" +
                "    c.userId AS user_id,\n" +
                "    u.username AS user_name,\n" +
                "    c_i.id AS cart_item_id,\n" +
                "    c_i.productId,\n" +
                "    c_i.quantity as cart_item_quantity,\n" +
                "    c_i.createdAt,\n" +
                "    c_i.updatedAt,\n" +
                "    p.id AS product_id,\n" +
                "    p.name AS product_name,\n" +
                "    p.price,\n" +
                "    p.discount,\n" +
                "    p.quantity as product_quantity,\n" +
                "    p.totalBuy,\n" +
                "    p.author,\n" +
                "    p.pages,\n" +
                "    p.publisher,\n" +
                "    p.yearPublishing,\n" +
                "    p.description,\n" +
                "    p.imageName,\n" +
                "    p.shop,\n" +
                "        -- Tính giá sau khi áp dụng discount (nếu có)\n" +
                "    (p.price * (1 - COALESCE(p.discount, 0) / 100)) AS discounted_price,\n" +
                "    -- Tính tổng tiền theo số lượng\n" +
                "    (c_i.quantity * (p.price * (1 - COALESCE(p.discount, 0) / 100))) AS total_price\n" +
                "FROM cart c\n" +
                "JOIN user u ON c.userId = u.id\n" +
                "JOIN cart_item c_i ON c_i.cartId = c.id\n" +
                "join product p on c_i.productId = p.id\n" +
                "WHERE c.userId = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                CartModel cartModel = null;
                List<CartItemModel> cartItems = new ArrayList<>();
                while (resultSet.next()) {
                    if (cartModel == null) {
                        cartModel = new CartModel(
                                resultSet.getInt("cart_id"),
                                resultSet.getInt("user_id"),
                                resultSet.getTimestamp("createdAt"),
                                resultSet.getTimestamp("updatedAt"),
                                cartItems
                        );
                    }

                    Integer cartItemId = resultSet.getInt("cart_item_id");
                    if (!resultSet.wasNull()) {
                        Double discountedPrice = resultSet.getDouble("discounted_price");
                        Double totalPrice = resultSet.getDouble("total_price");
                        ProductModel product = new ProductModel(
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("discount"),
                        resultSet.getInt("product_quantity"),
                        resultSet.getInt("totalBuy"),
                        resultSet.getString("author"),
                        resultSet.getInt("pages"),
                        resultSet.getString("publisher"),
                        resultSet.getInt("yearPublishing"),
                        resultSet.getString("description"),
                        resultSet.getString("imageName"),
                        resultSet.getBoolean("shop"),
                        discountedPrice
                        );

                        CartItemModel cartItem = new CartItemModel(
                                cartItemId,
                                resultSet.getInt("cart_id"),
                                resultSet.getInt("product_id"),
                                resultSet.getInt("cart_item_quantity"),
                                resultSet.getTimestamp("updatedAt"),
                                resultSet.getTimestamp("updatedAt"),
                                product,
                                totalPrice
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
        int testUserId = 4;

        System.out.println("Đang kiểm tra giỏ hàng của userId: " + testUserId);
        CartModel cart = cartDao.getCartByUserId(testUserId);

        if (cart == null) {
            System.out.println("Không tìm thấy giỏ hàng cho userId: " + testUserId);
        } else {
            System.out.println("Dữ liệu giỏ hàng:");
            System.out.println("Cart ID: " + cart.getId());
            System.out.println("User ID: " + cart.getUserId());
            System.out.println("Ngày tạo: " + cart.getCreatedAt());
            System.out.println("Ngày cập nhật: " + cart.getUpdatedAt());
            System.out.println("Danh sách sản phẩm:");

            for (CartItemModel item : cart.getCartItems()) {
                System.out.println("----------------------------");
                System.out.println("Sản phẩm: " + item.getProductModel().getName());
                System.out.println("Giá gốc: " + item.getProductModel().getPrice());
                System.out.println("Giảm giá: " + item.getProductModel().getDiscount() + "%");
                System.out.println("Giá sau giảm: " + item.getProductModel().getDiscountedPrice());
                System.out.println("Số lượng: " + item.getQuantity());
                System.out.println("Tổng tiền: " + item.getTotalPrice());
            }
        }
    }

}