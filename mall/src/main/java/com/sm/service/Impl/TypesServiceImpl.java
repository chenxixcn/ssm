package com.sm.service.Impl;

import com.sm.bean.Types;
import com.sm.dao.TypesMapper;
import com.sm.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;
    @Override
    public List<Types> getAllTypes() {
        return typesMapper.selectAllTypes();
    }

    @Override
    public Types getTypeById(Integer id) {
        return typesMapper.selectTypeById(id);
    }

    @Override
    public int addType(Types types) {
        return typesMapper.insertType(types);
    }

    @Override
    public int editType(Types types) {
        return typesMapper.updateType(types);
    }

    @Override
    public int deleteType(int id) {
        return typesMapper.deleteType(id);
    }
}
