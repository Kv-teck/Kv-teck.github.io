package com.quanlysach.quanlysach.controller.view;

import com.quanlysach.quanlysach.dao.impl.CategoryDaoImpl;
import com.quanlysach.quanlysach.dao.impl.ProductDaoImpl;
import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.model.ProductModel;
import com.quanlysach.quanlysach.service.ICategoryService;
import com.quanlysach.quanlysach.service.IProductService;
import com.quanlysach.quanlysach.service.impl.CategoryServiceImpl;
import com.quanlysach.quanlysach.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategorySeverlet", value = "/view/category")
public class CategorySeverlet extends HttpServlet {
    private final ICategoryService categoryService;
    private final IProductService productService;

    public CategorySeverlet() {
        this.categoryService = new CategoryServiceImpl(new CategoryDaoImpl());
        this.productService = new ProductServiceImpl(new ProductDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        String productId = req.getParameter("productId");

        List<CategoryModel> categoryModels = categoryService.getAllCategories();
        req.setAttribute("categoryModels", categoryModels);

        CategoryModel selectedCategory = categoryService.getCategoryById(categoryId);
        req.setAttribute("selectedCategory", selectedCategory);

        List<ProductModel> productByCategory = productService.getProductByCategory(categoryId);
        req.setAttribute("productModels", productByCategory);

        ProductModel selectedProduct = productService.getProductById(productId);
        req.setAttribute("selectedProduct", selectedProduct);

        req.getRequestDispatcher("/view/category.jsp").forward(req, resp);
    }
}
