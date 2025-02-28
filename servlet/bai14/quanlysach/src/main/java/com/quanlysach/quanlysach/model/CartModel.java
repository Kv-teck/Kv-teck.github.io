package com.quanlysach.quanlysach.model;


import java.util.Date;
import java.util.List;

public class CartModel {
    private Integer id;
    private Integer userId;
    private Date createdAt;
    private Date updatedAt;
    private List<CartItemModel> cartItems;


    public CartModel(Integer id, Integer userId, Date createdAt, Date updatedAt, List<CartItemModel> cartItems) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cartItems = cartItems;

    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CartItemModel> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemModel> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
