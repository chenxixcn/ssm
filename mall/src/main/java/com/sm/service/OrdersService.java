package com.sm.service;

import com.sm.bean.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> getAllOrders(int status);
    int delOrders(int id);
    int editOrders(int id,int status);
    boolean orderPay(Orders orders);

    int addOrder(int id);

    Orders getOrdersDetailByUserId(int id);

    List<Orders> getAllOrdersByUserId(int id);
}
