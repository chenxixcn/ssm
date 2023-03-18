package com.sm.service.Impl;

import com.sm.bean.Tops;
import com.sm.dao.TopsMapper;
import com.sm.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopsServiceImpl implements TopsService {
    @Autowired
    private TopsMapper topsMapper;
    @Override
    public int addTop(Tops tops) {
        return topsMapper.insertTop(tops);
    }

    @Override
    public int delTop(int good_id) {
        return topsMapper.deleteTopByGoodID(good_id);
    }
}
