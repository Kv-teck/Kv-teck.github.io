package com.quanlysach.quanlysach.controller;

import com.quanlysach.quanlysach.dao.impl.CategoryDaoImpl;
import com.quanlysach.quanlysach.dao.impl.ProductDaoImpl;
import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.model.ProductModel;
import com.quanlysach.quanlysach.service.ICategoryService;
import com.quanlysach.quanlysach.service.IProductService;
import com.quanlysach.quanlysach.service.impl.CategoryServiceImpl;
import com.quanlysach.quanlysach.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private final ICategoryService categoryService;
    private final IProductService productService;

    public HomeServlet() {
        this.categoryService = new CategoryServiceImpl(new CategoryDaoImpl());
        this.productService = new ProductServiceImpl(new ProductDaoImpl());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CategoryModel> categoryModels = categoryService.getAllCategories();
        req.setAttribute("categoryModels", categoryModels);

        List<ProductModel> productModels = productService.getAllProducts();
        req.setAttribute("productModels", productModels);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}