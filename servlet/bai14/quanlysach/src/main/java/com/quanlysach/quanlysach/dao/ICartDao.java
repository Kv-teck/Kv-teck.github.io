package com.quanlysach.quanlysach.dao;

import com.quanlysach.quanlysach.model.CartItemModel;
import com.quanlysach.quanlysach.model.CartModel;

import java.util.*;

public interface ICartDao {
    CartModel getCartByUserId(int userId);

}
