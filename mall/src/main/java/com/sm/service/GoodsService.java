package com.sm.service;

import com.sm.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods(int type);

    int addGoods(Goods goods);

    Goods getGoodsInfo(int id);

    int editGoods(Goods goods);

    int delGoods(int id);

    List<Goods> getTopGoods();

    List<Goods> getGoodsBySale();

    List<Goods> getGoodsById();

    List<Goods> getGoodsLikeName(String name);

    List<Goods> getGoodsByTypeId(int id);
}
