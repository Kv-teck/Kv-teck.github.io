package com.quanlysach.quanlysach.controller.admin;

import com.quanlysach.quanlysach.model.CategoryModel;
import com.quanlysach.quanlysach.model.ProductModel;
import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.util.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Admin", value = "/cms/admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy current user thông qua session, để kiểm tra xem user đã đăng nhập chưa
        UserModel currentUser = (UserModel) SessionUtil.getValue(req, SessionUtil.SESSION_ID_CURRENT_USER);
        if (currentUser == null) {
            System.out.println("Current User is null");
        } else {
            System.out.println("Current User: " + currentUser.toString());
        }
        req.setAttribute("currentUser", currentUser);
        req.setAttribute("message", "hello");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
