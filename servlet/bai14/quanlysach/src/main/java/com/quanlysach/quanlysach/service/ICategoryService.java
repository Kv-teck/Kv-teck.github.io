package com.quanlysach.quanlysach.service;

import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.model.ProductModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> getAllCategories();
    CategoryModel getCategoryById(String categoryId);
}
