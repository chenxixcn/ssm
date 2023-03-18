package com.sm.controller.admin;

import com.sm.bean.Tops;
import com.sm.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/tops")
public class TopsController {
    @Autowired
    private TopsService topsService;

    @RequestMapping("/addTop")
    public String addTop(Tops tops){
        topsService.addTop(tops);
        return "forward:/goods/goodsList";
    }

    @RequestMapping("/delTop")
    public String delTop(int good_id){
        topsService.delTop(good_id);
        return "forward:/goods/goodsList";
    }
}
