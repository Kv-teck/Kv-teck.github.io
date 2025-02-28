package com.quanlysach.quanlysach.security.impl;

import com.quanlysach.quanlysach.dao.impl.UserDaoImpl;
import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.security.IAuthenticationService;
import com.quanlysach.quanlysach.service.IUserService;
import com.quanlysach.quanlysach.service.impl.UserServiceImpl;
import com.quanlysach.quanlysach.util.Constants;
import com.quanlysach.quanlysach.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationServiceImpl implements IAuthenticationService {
    private final IUserService userService;

    public AuthenticationServiceImpl() {
        this.userService = new UserServiceImpl(new UserDaoImpl());

    }
    @Override
    public String signin(String username, String password, HttpServletRequest request) {
        //Authentication: Kiểm tra username, password có tồn tại trong database không
        UserModel userModel = userService.findUserByUserNameAndPassword(username, password);
        if (userModel == null) {
            return "/signin?message=loginError";
        }
        request.getSession().setAttribute(SessionUtil.SESSION_ID_CURRENT_USER, userModel);
        // Authorization: Kiểm tra user nếu có quyền Admin sẽ cho phép truy cập vào trang quản lý employee
        UserModel roleModel = userService.findUserByRoleId(userModel.getRole());
        String urlRedirect = "";
        if (Constants.ROLE.ADMIN.name().equalsIgnoreCase(roleModel.getRole())) {
            urlRedirect = "/cms/admin";
        } else if (Constants.ROLE.EMPLOYEE.name().equalsIgnoreCase(roleModel.getRole())) {
            urlRedirect = "/cms/admin-product";
        } else if (Constants.ROLE.CUSTOMER.name().equalsIgnoreCase(roleModel.getRole())) {
            urlRedirect = "/home";
        }
        return urlRedirect;

    }


}
