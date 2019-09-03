package com.trxk.scpww.service.userService;

import com.trxk.scpww.pojo.User;
import com.trxk.scpww.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class XinXiService {

    @Autowired
    UserMapper userMapper;
    public User selectByPrimaryKey(String id){
        System.out.println(id);
        User user = userMapper.selectByPrimaryKey(id);

        return user;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateByPrimaryKey(User user){

        boolean action = false;
        userMapper.updateByPrimaryKey(user);
        action = true ;
    return action;
    }

}
