package com.quanlysach.quanlysach.controller.admin;

import com.quanlysach.quanlysach.dao.impl.ProductDaoImpl;
import com.quanlysach.quanlysach.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductManager", value = "/cms/admin-product")
public class AdminProductManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDaoImpl productDao = new ProductDaoImpl();

        List<ProductModel> productModels = productDao.getAllProduct();
        req.setAttribute("productModels", productModels);

        req.getRequestDispatcher("/cms/admin-product.jsp").forward(req, resp);
    }
}
