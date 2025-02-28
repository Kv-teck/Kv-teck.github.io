package com.quanlysach.quanlysach.controller.view;

import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.security.IAuthenticationService;
import com.quanlysach.quanlysach.security.impl.AuthenticationServiceImpl;
import com.quanlysach.quanlysach.util.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(urlPatterns = {"/signin","/signout"})
public class SigninServlet extends HttpServlet {
    private IAuthenticationService authenticationService;
    public SigninServlet() {
        this.authenticationService = new AuthenticationServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }
        req.getSession().setAttribute("message", message);
        if (req.getRequestURI().startsWith("/signout")) {
            SessionUtil.removeValue(req, SessionUtil.SESSION_ID_CURRENT_USER);
            resp.sendRedirect("/home");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/signin.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String url = this.authenticationService.signin(username, password,req);
        resp.sendRedirect(url);
    }
}
