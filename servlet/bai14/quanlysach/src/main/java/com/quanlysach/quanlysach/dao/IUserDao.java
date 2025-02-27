package com.quanlysach.quanlysach.dao;

import com.quanlysach.quanlysach.model.UserModel;

public interface IUserDao {
    UserModel findUserByUserNameAndPassword(String username, String password);

    UserModel findUserByRoleId(String roleId);
}
