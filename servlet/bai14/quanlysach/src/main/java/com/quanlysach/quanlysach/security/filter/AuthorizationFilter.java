package com.quanlysach.quanlysach.security.filter;

import com.quanlysach.quanlysach.dao.impl.UserDaoImpl;
import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.service.IUserService;
import com.quanlysach.quanlysach.service.impl.UserServiceImpl;
import com.quanlysach.quanlysach.util.Constants;
import com.quanlysach.quanlysach.util.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private IUserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserModel currentUser = (UserModel) request.getSession().getAttribute(SessionUtil.SESSION_ID_CURRENT_USER);

        String uri = request.getRequestURI();
        if (uri.startsWith("/cms") ||(uri.startsWith("/cart"))) {
            if (currentUser != null) {
                String roleString = currentUser.getRole();

                if (roleString != null) {
                    Constants.ROLE userRole;
                    try {
                        userRole = Constants.ROLE.valueOf(roleString.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        response.sendRedirect("/home?message=" + Constants.PERMISSION_DENIED);
                        return;
                    }

                    // Kiểm tra quyền theo vai trò
                    if ((userRole == Constants.ROLE.ADMIN && Constants.ADMIN_PATHS.contains(uri)) ||
                            (userRole == Constants.ROLE.EMPLOYEE && Constants.EMPLOYEE_PATHS.contains(uri)) ||
                            (userRole == Constants.ROLE.CUSTOMER && Constants.CUSTOMER_PATHS.contains(uri))) {
                        filterChain.doFilter(request, response);
                        return;
                    }
                }
                response.sendRedirect("/home?message=" + Constants.PERMISSION_DENIED);
            } else {
                response.sendRedirect("/home?message=" + Constants.DONT_LOGIN);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
