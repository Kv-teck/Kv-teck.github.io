package com.quanlysach.quanlysach.dao;


import com.quanlysach.quanlysach.model.CategoryModel;

import java.util.List;

public interface ICategoryDao {
    List<CategoryModel> getAllCategory();
    CategoryModel getCategoryById(String categoryId);
}
