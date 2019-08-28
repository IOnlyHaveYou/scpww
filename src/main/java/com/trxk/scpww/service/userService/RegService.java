package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.pojo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RegService {
    public RegService() {
        System.out.println("--------------------------UserService构造函数");
    }

    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private JiFenMapper jiFenMapper;


    @Transactional(rollbackFor = Exception.class)
    public boolean userReg(User user){
        boolean action=false;
        try {

            user.setId(UUID.randomUUID().toString().replace("-",""));
            System.out.println("我就是新用户---------------"+user);
            userMapper.insert(user);

            action=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return action;
    }
}
