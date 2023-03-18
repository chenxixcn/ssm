package com.sm.controller;

import com.sm.bean.Depart;
import com.sm.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private DepartService departService;
    @RequestMapping("/selectByDStatus.do")
    public ModelAndView selectByDStatus(int dstatus){
        List<Depart> departs=departService.selectByStatus(dstatus);
        ModelAndView mav = new ModelAndView();
        mav.addObject("departs",departs);
        mav.setViewName("/depart.jsp");
        return mav;
    }
    @RequestMapping("/insertDepart.do")
        public String insertDepart(Depart depart){
            departService.addDepart(depart);
            return "/depart/selectByDStatus.do?dstatus=0";
    }
    @RequestMapping("/updateDepart.do")
    public String updateDepart(Depart depart){
        int dstatus=depart.getDstatus();
        departService.updateDepart(depart);
        return "/depart/selectByDStatus.do?dstatus="+dstatus;
    }
    @RequestMapping("/selectByDid.do")
    public ModelAndView selectByDid(int did){
        Depart dp=departService.selectByDid(did);
        ModelAndView mav = new ModelAndView();
        mav.addObject("depart",dp);
        mav.setViewName("/editDepart.jsp");
        return mav;
    }


}
