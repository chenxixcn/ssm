package com.sm.service;

import com.sm.bean.Users;

import java.util.List;

public interface UsersService {
    Users login(String username, String password);

    boolean register(Users users);

    int editStatus(String code);

    List<Users> getAllUsers();

    Users getUsersById(int id);

    int editUser(Users users);

    int addUser(Users users);

    int delUser(int id);
}
