package com.sm.dao;

import com.sm.bean.Admins;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminsMapper {
    List<Admins> selectAllAdmins();
    Admins selectAdminByUserAndPass(@Param("username") String username,@Param("password") String password);
    int insertAdmin(Admins admins);
    int deleteAdmin(int id);
}
