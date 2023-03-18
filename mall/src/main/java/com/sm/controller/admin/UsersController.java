package com.sm.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.Users;
import com.sm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.awt.SystemColor.info;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("/usersList")
    public ModelAndView usersList(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(page,size);
        List<Users> users=usersService.getAllUsers();
        PageInfo<Users> info=new PageInfo(users);
        mav.addObject("info",info);
        mav.setViewName("admin/user_list");
        return mav;
    }
    @RequestMapping("/getUser")
    public ModelAndView getUser(int id){
        ModelAndView mav = new ModelAndView();
        Users user = usersService.getUsersById(id);
        mav.addObject("user",user);
        mav.setViewName("admin/user_edit");
        return mav;
    }
    @RequestMapping("/editUser")
    public String  editUser(Users users){
        int i = usersService.editUser(users);
        return "forward:/users/usersList";
    }
    @RequestMapping("/addUser")
    public String  addUser(Users users){
        int i = usersService.addUser(users);
        return "forward:/users/usersList";
    }
    @RequestMapping("/delUser")
    public String  delUser(int id){
        int i = usersService.delUser(id);
        return "forward:/users/usersList";
    }
}
