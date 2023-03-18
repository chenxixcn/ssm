package com.sm.service.Impl;

import com.sm.bean.Users;
import com.sm.dao.UsersMapper;
import com.sm.service.UsersService;
import com.sm.utils.MailUtils;
import com.sm.utils.SafeUtil;
import com.sm.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users login(String username, String password) {
        return usersMapper.selectByUsernameAndPassword(username,password);
    }

    @Override
    public boolean register(Users users) {
        Users users1 = usersMapper.selectByUsername(users.getUsername());
        if (users1!=null){
            return false;
        }
        users.setPassword(SafeUtil.encode(users.getPassword()));
        users.setCode(UuidUtil.getUuid());
        users.setStatus("N");
        int ok=usersMapper.insertUser(users);
        if(ok==1){
            MailUtils.sendMail("3071435148@qq.com","你好，这是一封测试邮件，无需回复。<a href='http://localhost:8080/index/active?code="+users.getCode()+"'>点击激活</a>","测试邮件");
            System.out.println("发送成功");
            return true;
        }
        return false;
    }

    @Override
    public int editStatus(String code) {
        return usersMapper.UpdateByCode(code);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.selectAllUsers();
    }

    @Override
    public Users getUsersById(int id) {
        return usersMapper.selectUserByID(id);
    }

    @Override
    public int editUser(Users users) {
        return usersMapper.updateUsers(users);
    }

    @Override
    public int addUser(Users users) {
        users.setPassword(SafeUtil.encode(users.getPassword()));
        users.setCode(UuidUtil.getUuid());
        users.setStatus("N");
        return usersMapper.insertUser(users);
    }

    @Override
    public int delUser(int id) {
        return usersMapper.deleteUsers(id);
    }

}
