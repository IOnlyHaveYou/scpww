package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.JiFenService;
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
    @Autowired
    private JiFenService jiFenService;


    @Transactional(rollbackFor = Exception.class)
    public boolean userReg(User user) {
        boolean action = false;
        try {

            user.setId(UUID.randomUUID().toString().replace("-", ""));
            System.out.println("我就是新用户---------------" + user);
            userMapper.insert(user);
            jiFenService.insertUser(user);


            action = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return action;
    }

    /**
     * 用户名重名验证
     * @param username
     * @return
     */
    public boolean userCheckReg(String username) {
        boolean action = true;
        if (userMapper.selectByUserName(username)!=null){
            action=false;
        }
        return action;
    }


}
