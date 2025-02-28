package com.quanlysach.quanlysach.service;

import com.quanlysach.quanlysach.model.CartModel;

public interface ICartService {
    CartModel getCartByUserId(int userId);

}
