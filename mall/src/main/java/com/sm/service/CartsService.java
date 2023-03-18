package com.sm.service;

import com.sm.bean.Carts;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CartsService {

    int cartBuy(HttpSession session,Carts carts);

    List<Carts> getCartsByUserId(int id);

    List<Carts> getCartsDetailByUserId(int user_id);

    Integer getCartsTotal(int id);

    Integer getCartNum(int id);

    Boolean cartAdd(int id);

    Boolean cartLess(int id,HttpSession session);

    Boolean cartDelete(int id);
}
