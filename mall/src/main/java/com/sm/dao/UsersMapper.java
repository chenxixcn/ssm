package com.sm.dao;

import com.sm.bean.Goods;
import com.sm.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
   Users selectUserByID(int id);

    Users selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    Users selectByUsername(String username);

    int insertUser(Users users);

    int UpdateByCode(String code);

    List<Users> selectAllUsers();

    int updateUsers(Users users);

    int deleteUsers(int id);
}
