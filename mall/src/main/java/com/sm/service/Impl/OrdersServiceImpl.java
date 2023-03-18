package com.sm.service.Impl;

import com.sm.bean.Carts;
import com.sm.bean.Items;
import com.sm.bean.Orders;
import com.sm.dao.CartsMapper;
import com.sm.dao.ItemsMapper;
import com.sm.dao.OrdersMapper;
import com.sm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private CartsMapper cartsMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Orders> getAllOrders(int status) {
        return ordersMapper.selectAll(status);
    }

    @Override
    public int delOrders(int id) {
        //删除订单和订单项
        int ok1=ordersMapper.deleteOrdersById(id);
        int num=1/0;
        int ok2=itemsMapper.deleteItemsById(id);
        return ok1+ok2;
    }

    @Override
    public int editOrders(int id, int status) {
        return ordersMapper.updateOrdersStatusById(id,status);
    }

    @Override
    @Transactional
    public int addOrder(int id) {
        List<Carts> carts = cartsMapper.selectCartsDetail(id);
        Integer sum = cartsMapper.selectCartsTotalByUserId(id);
        double total=sum;
        int amount = carts.stream().mapToInt(Carts::getAmount).sum();
        //添加order数据
        for(Carts c:carts){
            if(c.getAmount()>c.getGoods().getStock()){
                System.out.println(c.getGoods().getName()+"库存不够");
            }
        }
        Orders orders = new Orders();
        orders.setId(0);
        orders.setTotal(total);
        orders.setAmount(amount);
        orders.setStatus(1);
        orders.setPaytype(0);
        orders.setSystime(new Date());
        orders.setUser_id(id);
        ordersMapper.insertOrder(orders);
//        添加items数据
        for(Carts c:carts){
            Items items = new Items();
            items.setId(0);
            items.setPrice(c.getGoods().getPrice()*c.getAmount());
            items.setAmount(c.getAmount());
            items.setGood_id(c.getGood_id());
            items.setOrder_id(orders.getId());
            itemsMapper.insertItems(items);
        }
//        清空购物车通过user_id
        boolean ok=cartsMapper.deleteAll(id);
        return orders.getId();
    }

    @Override
    public Orders getOrdersDetailByUserId(int id) {
        return ordersMapper.selectById(id);
    }

    @Override
    public List<Orders> getAllOrdersByUserId(int id) {
        return ordersMapper.selectOrderByUserId(id);
    }

    @Override
    public boolean orderPay(Orders orders) {
     return  ordersMapper.updateOrder(orders);
    }
}
