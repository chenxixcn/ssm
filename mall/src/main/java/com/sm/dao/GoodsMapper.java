package com.sm.dao;

import com.sm.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
   List<Goods> selectAllGoods(@Param("type") int type);

   int insertGoods(Goods goods);

    Goods selectGoodsById(int id);

    int updateGoodsById(Goods goods);

    int delGoodsById(int id);

    List<Goods> selectTopGoods();

    List<Goods> selectOrderBySale();

    List<Goods> selectGoodsOrderById();

    List<Goods> selectGoodsLikeName(@Param("name") String name);

    List<Goods> selectGoodsByTypeById(int id);
}
