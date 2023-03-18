package com.sm.dao;

import com.sm.bean.Tops;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopsMapper {
    int insertTop(Tops tops);
    int deleteTopByGoodID(@Param("good_id") int good_id);
}
