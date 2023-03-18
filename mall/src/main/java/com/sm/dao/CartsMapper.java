package com.sm.dao;

import com.sm.bean.Carts;
import com.sm.bean.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartsMapper {
    List<Carts> selectCartsByUserId(int id);

    int updateAmount(Carts carts);

    int insertCart(Carts carts);

    List<Carts>selectCartsDetail(int user_id);

    Integer selectCartsTotalByUserId(int user_id);

    Boolean cartDeleteId(int id);

    Integer selectCartNum(int id);

    Carts selectByCartId(int id);

    boolean deleteAll(int id);
}
