package com.sm.service;

import com.sm.bean.Types;

import java.util.List;

public interface TypesService {
    List<Types> getAllTypes();
    Types getTypeById(Integer id);
    int addType(Types types);
    int editType(Types types);
    int deleteType(int id);
}
