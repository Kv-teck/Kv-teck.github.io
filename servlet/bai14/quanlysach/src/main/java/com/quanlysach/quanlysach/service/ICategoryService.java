package com.quanlysach.quanlysach.service;

import com.quanlysach.quanlysach.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> getAllCategories();
    CategoryModel getCategoryById(String categoryId);
}
