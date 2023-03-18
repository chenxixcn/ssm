package com.sm.dao;

import com.sm.bean.Items;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsMapper {
    Items selectItemsByOrderId(int order_id);
    int deleteItemsById(int id);

    boolean insertItems(Items items);
}
