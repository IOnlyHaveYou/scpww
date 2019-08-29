package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    public LoginService() {
        System.out.println("--------------------------UserService构造函数");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public User Userlogin(User user) {
        user = userMapper.selectUserByNameAndPassword(user);
        System.out.println("dhlfjlsdfldj---------" + user);
        return user;

    }
}
