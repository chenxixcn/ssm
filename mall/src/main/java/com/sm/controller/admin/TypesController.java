package com.sm.controller.admin;

import com.sm.bean.Types;
import com.sm.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/types")
public class TypesController {
    @Autowired
    private TypesService typesService;
    @RequestMapping("/typeList")
    public ModelAndView getAllTypes(){
        ModelAndView mav = new ModelAndView();
        List<Types> types=typesService.getAllTypes();
        mav.addObject("types",types);
        mav.addObject("flag",1);
        mav.setViewName("admin/type_list");
        return  mav;
    }
    @RequestMapping("/typeAdd")
    public String typeAdd(Types types){
        typesService.addType(types);
        return  "forward:/types/typeList";
    }
    @RequestMapping("/toTypeEdit")
    public ModelAndView toTypeEdit(int id){
        ModelAndView mav = new ModelAndView();
        Types type=typesService.getTypeById(id);
        mav.addObject("type",type);
        mav.setViewName("admin/type_edit");
        return  mav;
    }
    @RequestMapping("/typeEdit")
    public String typeEdit(Types types){
        typesService.editType(types);
        return  "forward:/types/typeList";
    }
    @RequestMapping("/typeDelete")
    public String typeDelete(int id){
        typesService.deleteType(id);
        return  "forward:/types/typeList";
    }
}
