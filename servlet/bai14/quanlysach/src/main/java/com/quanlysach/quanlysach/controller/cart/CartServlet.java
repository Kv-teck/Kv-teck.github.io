package com.quanlysach.quanlysach.controller.cart;

import com.quanlysach.quanlysach.model.CartModel;
import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.service.ICartService;
import com.quanlysach.quanlysach.service.impl.CartServiceImpl;
import com.quanlysach.quanlysach.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    private ICartService cartService;

    @Override
    public void init() {
        cartService = new CartServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy current user thông qua session, để kiểm tra xem user đã đăng nhập chưa
        UserModel currentUser = (UserModel) SessionUtil.getValue(req, SessionUtil.SESSION_ID_CURRENT_USER);
        if (currentUser == null) {
            System.out.println("Current User is null");
        } else {
            System.out.println("Current User: " + currentUser.toString());
        }


        int userId = currentUser.getId();
        CartModel cart = cartService.getCartByUserId(userId);

        req.setAttribute("currentUser", currentUser);
        req.setAttribute("message", "hello");

        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/cart/cart.jsp").forward(req, resp);
    }
}

