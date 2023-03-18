package com.sm.controller.index;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.*;
import com.sm.service.*;
import com.sm.utils.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypesService typesService;

    @Autowired
    private CartsService cartsService;

    @Autowired
    private OrdersService ordersService;
    /**
     *前台商城首页
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpSession session){
        ModelAndView mav = new ModelAndView();
        //今日推荐
        List<Goods> topGoods = goodsService.getTopGoods();
        mav.addObject("topGoods",topGoods);
        //热销商品
        List<Goods> goodsOrderBySale = goodsService.getGoodsBySale();
        List<Goods> goodsTree = goodsOrderBySale.subList(0, 3);
        List<Goods> goodsFive = goodsOrderBySale.subList(3, 8);
        mav.addObject("goodsBySaleTree",goodsTree);
        mav.addObject("goodsBySaleFive",goodsFive);
        //类目
        List<Types> types = typesService.getAllTypes();
        mav.addObject("allTypes",types);
        session.setAttribute("allTypes",types);
        //类目商品
        Map<String,List<Goods>> goodsMap=new HashMap<>();
        for (Types t:types){
            List<Goods> goodsStream = goodsOrderBySale.stream().filter(goods -> goods.getType_id() == t.getId()).collect(Collectors.toList());
            goodsMap.put(t.getName(),goodsStream);
        }
        //购物车数据

        Users userInfo = (Users) session.getAttribute("userInfo");
        if(userInfo !=null){
            List<Carts> carts = cartsService.getCartsByUserId(userInfo.getId());
            int  cartsSum= carts.stream().mapToInt(Carts::getAmount).sum();
            //为什么要加userId变成userId+"cartNum"
            session.setAttribute("cartNum",cartsSum);
            session.setAttribute("cartsInfo",carts);
        }

        mav.addObject("url","index");
        mav.addObject("goodsMap",goodsMap);
        mav.setViewName("index/index");
        return mav;
    }

    /*
     *注销用户账号
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userInfo");
        return "forward:/index/index";
    }
    /*
     *前台用户登录判断账号是否邮箱激活未激活不可登录
     */
    @RequestMapping("/login")
    public ModelAndView login(String username,String password,HttpSession session){
        ModelAndView mav = new ModelAndView();
        Users users=usersService.login(username, SafeUtil.encode(password));
        if(users==null){
            mav.addObject("msg","登录失败");
            mav.setViewName("index/login");
            return mav;
        }
        if(users.getStatus().equals("N")){
            mav.setViewName("index/login");
            mav.addObject("msg","还未激活");
            return mav;
        }
        session.setAttribute("userInfo",users);
        mav.setViewName("forward:/index/index");
        return mav;
    }
    /*
     *注册账号
     */
    @RequestMapping("/register")
    public ModelAndView register(Users users){
        ModelAndView mav = new ModelAndView();
        boolean isOK=usersService.register(users);
        if (isOK){
            mav.setViewName("index/register_ok");
            return mav;
        }
        mav.addObject("msg","注册失败");
        mav.setViewName("index/register");
        return mav;
    }
    /*
     *激活成功跳登录页面
     */
    @RequestMapping("/active")
    public ModelAndView active(String code){
        int isOk=usersService.editStatus(code);
        ModelAndView mav = new ModelAndView();
        if(isOk==1){
            mav.addObject("msg","激活成功");
            mav.setViewName("index/login");
            return mav;
        }
        mav.addObject("msg","激活失败，请联系管理员");
        mav.setViewName("index/login");
        return mav;
    }
    @RequestMapping("/todayHotNew") //所有主goods.jsp，id为typeId
    public ModelAndView getTodayHotNew(String url,HttpSession session,
                                       @RequestParam(defaultValue = "0")String name,
                                       @RequestParam(defaultValue = "0")int id,
                                       @RequestParam(defaultValue = "1")int page,
                                       @RequestParam(defaultValue = "5")int size){
        ModelAndView mav = new ModelAndView();
        PageInfo<Goods> info=null;
        if(url.equals("today")){
            PageHelper.startPage(page,size);
            List<Goods> topGoods = goodsService.getTopGoods();
            info = new PageInfo<>(topGoods);
            mav.addObject("url",url);
        }
        if(url.equals("hot")){
            PageHelper.startPage(page,size);
            List<Goods> topGoods = goodsService.getGoodsBySale();
            info = new PageInfo<>(topGoods);
            mav.addObject("url",url);
        }
        if(url.equals("new")){
            PageHelper.startPage(page,size);
            List<Goods> topGoods = goodsService.getGoodsById();
            info = new PageInfo<>(topGoods);
            mav.addObject("url",url);
        }
        if(url.equals("search")){
            PageHelper.startPage(page,size);
            List<Goods> topGoods = goodsService.getGoodsLikeName(name);
            info = new PageInfo<>(topGoods);
            mav.addObject("name",name);
            mav.addObject("url",url+"&name="+name);
        }
        if(url.equals("type")){
            PageHelper.startPage(page,size);
            List<Goods> topGoods = goodsService.getGoodsByTypeId(id);
            info = new PageInfo<>(topGoods);
            mav.addObject("url",url+"&id="+id);
        }
        mav.addObject("info",info);
        mav.setViewName("index/goods");
        return mav;
    }
    //添加商品至购物车
    @ResponseBody
    @RequestMapping("/cartBuy")
    public Boolean  cartBuy(HttpSession session,Carts carts){
        System.out.println(carts);
        //判断是否更新成功，返回布尔类型给前端
        if(cartsService.cartBuy(session,carts)==1){
            return true;
        }
        return false;
    }
//    @RequestMapping("/detail")
//    public ModelAndView logout(int id,ModelAndView mav){
//        Goods goods = goodsService.getGoodsInfo(id);
//        mav.addObject("goods",goods);
//        mav.setViewName("index/detail");
//        List<Goods> goodsOrderBySale = goodsService.getGoodsBySale();
//        List<Goods> goodsTwo = goodsOrderBySale.subList(0, 2);
//        mav.addObject("goodsBySaleTwo",goodsTwo);
//        return mav;
//    }
    //商品详细
    @RequestMapping("/detail")
    public String detail(int id,Model mav){
        Goods goods = goodsService.getGoodsInfo(id);
        mav.addAttribute("goods",goods);
        List<Goods> goodsOrderBySale = goodsService.getGoodsBySale();
        List<Goods> goodsTwo = goodsOrderBySale.subList(0, 2);
        mav.addAttribute("goodsBySaleTwo",goodsTwo);
        return "index/detail";
    }
    //将数据渲染到购物车页面
    @RequestMapping("/cart")
    public String getAllCarts(HttpSession session,Model mav){
        Users user= (Users) session.getAttribute("userInfo");
        List<Carts> carts = cartsService.getCartsDetailByUserId(user.getId());
        if(!carts.isEmpty()){
            System.out.println(carts);
            mav.addAttribute("carts",carts);
        }
        Integer  cartTotal= cartsService.getCartsTotal(user.getId());
        mav.addAttribute("cartTotal",cartTotal);
        Users userInfo = (Users) session.getAttribute("userInfo");
        System.out.println(userInfo);
        //下面两条可以去掉
//        Integer cartNum = cartsService.getCartNum(userInfo.getId());
//        session.setAttribute("cartNum",cartNum);
        return "index/cart";
    }
    //购物车总金额
    @ResponseBody
    @RequestMapping("cartTotal")
    public Integer cartTotal(HttpSession session){
        Users user= (Users) session.getAttribute("userInfo");
        Integer  cartTotal= cartsService.getCartsTotal(user.getId());
        return cartTotal;
    }
    //商品数目
    @ResponseBody
    @RequestMapping("cartAllAmount")
    public Integer cartAllAmount(HttpSession session){
        Users userInfo = (Users) session.getAttribute("userInfo");
        Integer cartNum = cartsService.getCartNum(userInfo.getId());
        session.setAttribute("cartNum",cartNum);
        return cartNum;
    }
    //购物车商品添加
    @ResponseBody
    @RequestMapping("cartAdd")
    public Boolean cartAdd(int id){
        return cartsService.cartAdd(id);
    }
    //购物车商品减少
    @ResponseBody
    @RequestMapping("cartLess")
    public Boolean cartLess(int id,HttpSession session){
        return cartsService.cartLess(id,session);
    }
    //购物车商品删除
    @ResponseBody
    @RequestMapping("cartDelete")
    public Boolean cartDelete(int id){
        return cartsService.cartDelete(id);
    }
    //结算
    @RequestMapping("/orderSave")
    public ModelAndView getOrderSave(HttpSession session){
        ModelAndView mav = new ModelAndView();
        Users user= (Users) session.getAttribute("userInfo");
        List<Carts> carts = cartsService.getCartsDetailByUserId(user.getId());
        int total=0;
        int id=0;
        System.out.println("orderSave:"+carts);
        if(carts!=null){
            for(Carts c:carts){
                total+=c.getGoods().getPrice()*c.getAmount();
            }
           id= ordersService.addOrder(user.getId());
        }
        session.removeAttribute("cartNum");
        Orders orders = ordersService.getOrdersDetailByUserId(id);
        mav.addObject("cartTotal",total);
        mav.addObject("orders",orders);
        mav.setViewName("index/pay");
        return mav;
    }
    //付款
    @RequestMapping("/orderPay")
    public ModelAndView getOrderPay(Orders orders){
        ModelAndView mav = new ModelAndView();
        ordersService.orderPay(orders);
        if(orders.getPaytype()==1){

        }
        if(orders.getPaytype()==2){

        }
        mav.setViewName("index/payOk");
        return mav;
    }
    //订单页面
    @RequestMapping("/order")
    public ModelAndView getOrder(HttpSession session,
                                 @RequestParam(defaultValue = "1")int page,
                                 @RequestParam(defaultValue = "5")int size){
        ModelAndView mav = new ModelAndView();
        Users user= (Users) session.getAttribute("userInfo");
        PageHelper.startPage(page,size);
        List<Orders> orderList = ordersService.getAllOrdersByUserId(user.getId());
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(orderList);
        mav.addObject("orderList",ordersPageInfo);
        mav.setViewName("index/order");
        return mav;
    }
    //订单状态修改
    @RequestMapping("/orderStatus")
    public ModelAndView orderStatus(HttpSession session,int id,int status){
        ModelAndView mav = new ModelAndView();
        if (status==1){
            Orders orders = ordersService.getOrdersDetailByUserId(id);
            mav.addObject("orders",orders);
            mav.setViewName("index/pay");
            return mav;
        }
        int i = ordersService.editOrders(id,status);
        mav.setViewName("forward:/index/order");
        return mav;
    }
    //修改地址
    @RequestMapping("/addressUpdate")
    public ModelAndView addressUpdate(HttpSession session,Users users){
        ModelAndView mav = new ModelAndView();
        Users user= (Users) session.getAttribute("userInfo");
        Users users1 = new Users();
        users1.setName(users.getName());
        users1.setPhone(users.getPhone());
        users1.setAddress(users.getAddress());
        users1.setId(user.getId());
        int i = usersService.editUser(users1);
        mav.setViewName("index/address");
        if (i==1){
            Users userInfo = usersService.getUsersById(user.getId());
            session.setAttribute("userInfo",userInfo);
            mav.addObject("msg","修改成功");
        }else {
            mav.addObject("msg", "修改失败");
        }
        return mav;
    }
    //修改密码
    @RequestMapping("/passwordUpdate")
    public String passwordUpdate(HttpSession session,Model model,String password,String passwordNew){
        Users user= (Users) session.getAttribute("userInfo");
        if(!SafeUtil.encode(password).equals(user.getPassword())){
            model.addAttribute("msg","原密码错误!");
            return "index/password";
        }
        if(SafeUtil.encode(passwordNew).equals(user.getPassword())){
            model.addAttribute("msg","新密码不能与原密码一致!");
            return "index/password";
        }
        Users users1 = new Users();
        users1.setPassword(SafeUtil.encode(passwordNew));
        users1.setId(user.getId());
        int i = usersService.editUser(users1);
        if(i==1){
            model.addAttribute("msg","修改成功，请重新登录");
            return "index/login";
        }
        model.addAttribute("msg","由于系统内部原因修改错误");
        return "index/password";
    }

}
