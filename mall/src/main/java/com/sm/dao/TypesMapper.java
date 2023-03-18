package com.sm.dao;

import com.sm.bean.Types;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypesMapper {
    List<Types> selectAllTypes();
    Types selectTypeById(Integer id);
    int insertType(Types types);
    int updateType(Types types);
    int deleteType(Integer id);
}
