package com.quanlysach.quanlysach.service;

import com.quanlysach.quanlysach.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> getAllProducts();
    List<ProductModel> getProductByCategory(String category);
    ProductModel getProductById(String productId);

}
