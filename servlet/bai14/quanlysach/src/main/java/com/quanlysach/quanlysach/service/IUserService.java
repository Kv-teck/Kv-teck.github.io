package com.quanlysach.quanlysach.service;

import com.quanlysach.quanlysach.model.UserModel;

public interface IUserService {
    UserModel findUserByUserNameAndPassword(String username, String password);
    UserModel findUserByRoleId(String roleId);
}
