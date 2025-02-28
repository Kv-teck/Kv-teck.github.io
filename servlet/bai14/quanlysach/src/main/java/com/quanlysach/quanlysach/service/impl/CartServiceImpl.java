package com.quanlysach.quanlysach.service.impl;

import com.quanlysach.quanlysach.dao.ICartDao;
import com.quanlysach.quanlysach.dao.impl.CartDaoImpl;
import com.quanlysach.quanlysach.model.CartModel;
import com.quanlysach.quanlysach.service.ICartService;


public class CartServiceImpl implements ICartService {
    private final ICartDao cartDao;

    public CartServiceImpl(ICartDao cartDao) {
        this.cartDao = cartDao;
    }

    public CartServiceImpl() {
        this(new CartDaoImpl());
    }

    @Override
    public CartModel getCartByUserId(int userId) {
        return cartDao.getCartByUserId(userId);
    }

}
