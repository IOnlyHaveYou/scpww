package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.pojo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

@Service
public class UpdateService {
    public UpdateService() {
        System.out.println("--------------------------UserService构造函数");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean UserUpdate(User user) {
        boolean action=false;
        if ( userMapper.updateByPrimaryKeySelective(user)!=0){
            action=true;
        }

        return action;

    }

    public boolean passwordUpdate(User user) {
        boolean action=false;
        if ( userMapper.updateByPrimaryKeySelective(user)!=0){
            action=true;
        }

        return action;

    }
}
