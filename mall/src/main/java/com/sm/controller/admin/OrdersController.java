package com.sm.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.Orders;
import com.sm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/orderList")
    public ModelAndView orderList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "0") int status){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(page,size);
        List<Orders> orders=ordersService.getAllOrders(status);
        PageInfo<Orders> info = new PageInfo(orders);
        mav.addObject("info",info);
        mav.addObject("status",status);
        mav.addObject("flag",3);
        mav.setViewName("admin/order_list");
        return mav;
    }
    @RequestMapping("/delOrders")
    public String delOrders(int id){
        int ok=ordersService.delOrders(id);
        if(ok==2){
            System.out.println("订单和订单项全部删除");
        }
        return "forward:/orders/orderList?status=0";
    }
    @RequestMapping("/editOrders")
    public String editOrders(int id,int status){
        ordersService.editOrders(id,status);
        return "forward:/orders/orderList?status=0";
    }
    //点击发货传status=3，跳转到了代配送页面
}
