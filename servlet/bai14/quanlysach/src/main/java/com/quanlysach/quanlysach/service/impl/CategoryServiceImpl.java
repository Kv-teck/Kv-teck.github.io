package com.quanlysach.quanlysach.service.impl;

import com.quanlysach.quanlysach.dao.impl.CategoryDaoImpl;
import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    @Override
    public CategoryModel getCategoryById(String categoryId) {
        if (categoryId == null || categoryId.trim().isEmpty()) {
            return new CategoryModel();
        }
        try {
            return categoryDao.getCategoryById(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return new CategoryModel();
        }
    }

    private final CategoryDaoImpl categoryDao;

    public CategoryServiceImpl(CategoryDaoImpl categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryDao.getAllCategory();
    }

}
