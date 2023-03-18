package com.sm.service.Impl;

import com.sm.bean.Carts;
import com.sm.bean.Items;
import com.sm.bean.Orders;
import com.sm.bean.Users;
import com.sm.dao.CartsMapper;
import com.sm.dao.ItemsMapper;
import com.sm.dao.OrdersMapper;
import com.sm.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartsServiceImpl implements CartsService {
    @Autowired
    private CartsMapper cartsMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public int cartBuy(HttpSession session,Carts carts) {
        int flag=0;
        //判断是否登录，不登录，不可添加，可不用写，写一个拦截器更好
        Users userInfo = (Users) session.getAttribute("userInfo");
        if(userInfo==null){
            return flag;
        }
        //从session中取得/index/index处理器下保存的carts值，这里有个bug，
        // 当用户未刷新主页carts值不变，添加商品会导致后面重复的全都是添加，
        // 修改则amount一直为2
//        List<Carts> cartsList = (List<Carts>) session.getAttribute("carts");
//        System.out.println(cartsList);
        List<Carts> cartsList = cartsMapper.selectCartsByUserId(userInfo.getId());
        //用java处理对象集合，得到该用户是否已添加该商品
        Optional<Carts> carts1 = cartsList.stream().filter(c -> c.getGood_id() == carts.getGood_id()).findFirst();
        System.out.println(carts1);
        System.out.println(carts1.isPresent());
        //当已添加商品时，将该条id的数量加一
        if(carts1.isPresent()){
            //carts1.get().getAmount()得到已添加商品的数目
            carts.setAmount(carts1.get().getAmount()+1);
            carts.setId(carts1.get().getId());
            flag= cartsMapper.updateAmount(carts);
            Integer cartNum = cartsMapper.selectCartNum(userInfo.getId());
            session.setAttribute("cartNum",cartNum);
            return flag;
        }
        //没有添加，则执行添加语句
        Carts carts2 = new Carts(0, 1, carts.getGood_id(), userInfo.getId(),null);
        flag= cartsMapper.insertCart(carts2);
        Integer cartNum = cartsMapper.selectCartNum(userInfo.getId());
        session.setAttribute("cartNum",cartNum);
        return flag;
    }

    @Override
    public List<Carts> getCartsByUserId(int id) {
        return cartsMapper.selectCartsByUserId(id);
    }

    @Override
    public List<Carts> getCartsDetailByUserId(int user_id) {
        return cartsMapper.selectCartsDetail(user_id);
    }

    @Override
    public Integer getCartsTotal(int user_id) {
        return cartsMapper.selectCartsTotalByUserId(user_id);
    }

    @Override
    public Integer getCartNum(int id) {
        return cartsMapper.selectCartNum(id);
    }

    @Override
    public Boolean cartAdd(int id) {
        Carts carts = cartsMapper.selectByCartId(id);
        if(carts.getGoods().getStock()==0){
            return false;
        }
        Carts cart = new Carts();
        cart.setAmount(carts.getAmount()+1);
        cart.setId(id);
        if(cartsMapper.updateAmount(cart)==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean cartLess(int id, HttpSession session) {
        Carts carts  = cartsMapper.selectByCartId(id);
        if(carts.getAmount()==1){
           return cartsMapper.cartDeleteId(id);
        }
        Carts cart = new Carts();
        cart.setAmount(carts.getAmount()-1);
        cart.setId(id);
        if(cartsMapper.updateAmount(cart)==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean cartDelete(int id) {
        return cartsMapper.cartDeleteId(id);
    }

}
