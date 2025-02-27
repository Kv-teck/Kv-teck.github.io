package com.quanlysach.quanlysach.dao;

import com.quanlysach.quanlysach.model.ProductModel;

import java.util.List;

public interface IProductDao {
    List<ProductModel> getAllProduct();
    List<ProductModel> getProductByCategory(String category);
    ProductModel getProductById(String productId);
}
