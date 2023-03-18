package com.sm.service.Impl;

import com.sm.bean.Admins;
import com.sm.dao.AdminsMapper;
import com.sm.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;

    @Override
    public List<Admins> selectAll() {
        return adminsMapper.selectAllAdmins();
    }

    @Override
    public Admins selectAdmin(String username, String password) {
        return adminsMapper.selectAdminByUserAndPass(username,password);
    }

    @Override
    public int addAdmin(Admins admins) {
        return adminsMapper.insertAdmin(admins);
    }

    @Override
    public int delAdmin(int id) {
        return adminsMapper.deleteAdmin(id);
    }
}
