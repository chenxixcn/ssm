package com.sm.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.Admins;
import com.sm.bean.Users;
import com.sm.service.AdminsService;
import com.sm.utils.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;
    /*
     *
     */
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(page,size);
        List<Admins> admins=adminsService.selectAll();
        PageInfo<Admins> info=new PageInfo(admins);
        mav.addObject("info",info);
        mav.setViewName("admin/admin_list");
        return mav;
    }
    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Admins admin=adminsService.selectAdmin(username, SafeUtil.encode(password));
        if(admin!=null){
            session.setAttribute("admin",admin);
            mav.setViewName("admin/index");
            mav.addObject("msg","登录成功");
            return mav;
        }
        mav.addObject("msg","登录失败");
        mav.setViewName("admin/login");
        return mav;
    }
    @RequestMapping("/logOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("admin");
        return "admin/login";
    }
    @RequestMapping("/addAdmin")
    public String addAdmin(Admins admins){
        int i = adminsService.addAdmin(admins);
        return "forward:/admin/selectAll";
    }
    @RequestMapping("/delAdmin")
    public String delAdmin(int id){
        int i = adminsService.delAdmin(id);
        return "forward:/admin/selectAll";
    }
}
