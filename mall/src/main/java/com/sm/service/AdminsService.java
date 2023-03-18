package com.sm.service;

import com.sm.bean.Admins;

import java.util.List;

public interface AdminsService {
    List<Admins> selectAll();
    Admins selectAdmin(String username,String password);
    int addAdmin(Admins admins);
    int delAdmin(int id);
}
