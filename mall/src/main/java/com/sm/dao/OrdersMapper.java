package com.sm.dao;

import com.sm.bean.Orders;
import com.sm.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    List<Orders> selectAll(@Param("status") int status);
    int deleteOrdersById(int id);
    int updateOrdersStatusById(@Param("id") int id,@Param("status") int status);

    boolean insertOrder(Orders orders);

    boolean updateOrder(Orders orders);

    Orders selectById(int id);

    List<Orders> selectOrderByUserId(int id);
}
