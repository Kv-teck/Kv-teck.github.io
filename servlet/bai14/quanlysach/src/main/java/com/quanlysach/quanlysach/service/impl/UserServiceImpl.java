package com.quanlysach.quanlysach.service.impl;


import com.quanlysach.quanlysach.dao.IUserDao;
import com.quanlysach.quanlysach.model.UserModel;
import com.quanlysach.quanlysach.service.IUserService;
import com.quanlysach.quanlysach.util.PasswordUtils;

public class UserServiceImpl implements IUserService {
    @Override
    public UserModel findUserByRoleId(String roleId) {
        return userDao.findUserByRoleId(roleId);
    }

    private final IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public UserModel findUserByUserNameAndPassword(String username, String password) {

        String passwordEncrypt = PasswordUtils.encrypt(password);
        return userDao.findUserByUserNameAndPassword(username, passwordEncrypt);
    }
}
