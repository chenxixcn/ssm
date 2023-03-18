package com.sm.service.Impl;

import com.sm.bean.Goods;
import com.sm.dao.GoodsMapper;
import com.sm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAllGoods(int type) {
        return goodsMapper.selectAllGoods(type);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public Goods getGoodsInfo(int id) {
        return goodsMapper.selectGoodsById(id);
    }

    @Override
    public int editGoods(Goods goods) {
        return goodsMapper.updateGoodsById(goods);
    }

    @Override
    public int delGoods(int id) {
        return goodsMapper.delGoodsById(id);
    }

    @Override
    public List<Goods> getTopGoods() {
        return goodsMapper.selectTopGoods();
    }

    @Override
    public List<Goods> getGoodsBySale() {
        return goodsMapper.selectOrderBySale();
    }

    @Override
    public List<Goods> getGoodsById() {
        return goodsMapper.selectGoodsOrderById();
    }

    @Override
    public List<Goods> getGoodsLikeName(String name) {
        return goodsMapper.selectGoodsLikeName(name);
    }

    @Override
    public List<Goods> getGoodsByTypeId(int id) {
        return goodsMapper.selectGoodsByTypeById(id);
    }
}
