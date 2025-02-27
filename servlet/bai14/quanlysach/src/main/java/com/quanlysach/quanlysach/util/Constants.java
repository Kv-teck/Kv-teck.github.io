package com.quanlysach.quanlysach.util;

import java.util.Set;

public class Constants {
    public static final String ADD_EMPLOYEE_ERROR = "addEmployeeError";
    public static final String ADD_EMPLOYEE_SUCCESS = "addEmployeeSuccess";
    public static final String PERMISSION_DENIED = "permissionDenied";
    public static final String DONT_LOGIN = "dontLogin";
    public static final String LOGIN_SUCCESS = "loginSuccess";
    public static final String LOGIN_FAIL = "loginFail";

    public enum ROLE {
        ADMIN, EMPLOYEE, CUSTOMER
    }

    // Khai báo quyền theo vai trò
    public static final Set<String> ADMIN_PATHS = Set.of(
            "/cms/admin",
            "/cms/admin-product",
            "/cms/admin-add-product"
    );
    public static final Set<String> EMPLOYEE_PATHS = Set.of(
            "/cms/admin-product",
            "/cms/admin-add-product"
    );
    public static final Set<String> CUSTOMER_PATHS = Set.of(
            "/home",
            "/cart"
    );
}
