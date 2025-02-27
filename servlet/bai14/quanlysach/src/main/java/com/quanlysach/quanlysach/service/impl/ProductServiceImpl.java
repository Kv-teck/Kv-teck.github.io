package com.quanlysach.quanlysach.service.impl;

import com.quanlysach.quanlysach.dao.impl.ProductDaoImpl;
import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.model.ProductModel;
import com.quanlysach.quanlysach.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Override
    public ProductModel getProductById(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            return new ProductModel();
        }
        try {
            return productDao.getProductById(productId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ProductModel();
        }
    }

    private final ProductDaoImpl productDao;

    public ProductServiceImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }
    @Override
    public List<ProductModel> getAllProducts() {
        return productDao.getAllProduct();
    }

    @Override
    public List<ProductModel> getProductByCategory(String category) {
        return productDao.getProductByCategory(category);
    }

}
