package com.sm.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.Goods;
import com.sm.bean.Types;
import com.sm.service.GoodsService;
import com.sm.service.TypesService;
import com.sm.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypesService typesService;
    @RequestMapping("/goodsList")
    public ModelAndView getAllGoods(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "5") int size,
                                    @RequestParam(defaultValue = "0") int type){
        PageHelper.startPage(page,size);
        List<Goods> goods = goodsService.getAllGoods(type);
        PageInfo<Goods> info=new PageInfo(goods);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info",info);
        mav.addObject("type",type);
        mav.addObject("flag",2);
        mav.setViewName("admin/good_list");
        return mav;
    }
    @RequestMapping("/getAllType")
    public ModelAndView getAllType(){
        ModelAndView mav = new ModelAndView();
        List<Types> types = typesService.getAllTypes();
        mav.addObject("types",types);
        mav.setViewName("admin/good_add");
        return mav;
    }
    @RequestMapping("/goodSave")
    public String goodSave(Goods goods, MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException {
        String path = httpServletRequest.getServletContext().getRealPath("upload");
        String name= UuidUtil.getUuid()+"_"+multipartFile.getOriginalFilename();
        File file = new File(path, name);
        multipartFile.transferTo(file);
        goods.setCover("../upload/"+name);
        goodsService.addGoods(goods);
        return "forward:/goods/goodsList";
    }
    @RequestMapping("/getGoodsInfo")
    public ModelAndView getGoodsInfo(int id,int page){
        ModelAndView mav = new ModelAndView();
        Goods goods= goodsService.getGoodsInfo(id);
        mav.addObject("goods",goods);
        mav.addObject("page",page);
        List<Types> types = typesService.getAllTypes();
        mav.addObject("types",types);
        mav.setViewName("admin/good_edit");

        return mav;
    }
    @RequestMapping("/goodEdit")
    public String goodEdit(Goods goods,int page ,MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException {
       if(multipartFile.getSize()!=0){
           String path = httpServletRequest.getServletContext().getRealPath("upload");
           String name= UuidUtil.getUuid()+"_"+multipartFile.getOriginalFilename();
           File file = new File(path, name);
           multipartFile.transferTo(file);
           String oldName=goods.getCover();
           String old=oldName.substring(oldName.lastIndexOf("/")+1);
           File oldFile = new File(path, old);
           oldFile.delete();
           goods.setCover("../upload/"+name);
       }
        //验证将dao层param删掉是否还会绑定数据
        //验证将goods.setCover("../upload/"+name);移到前面
        //重新打一遍上传代码

        goodsService.editGoods(goods);
        return "forward:/goods/goodsList?page="+page;
    }
    @RequestMapping("/delGoods")
    public String delGoods(int id,int page){
        goodsService.delGoods(id);
        return "forward:/goods/goodsList?page="+page;
    }
}
