package com.quanlysach.quanlysach.security;

import jakarta.servlet.http.HttpServletRequest;

public interface IAuthenticationService {
    public String signin(String username, String password, HttpServletRequest request);
}
