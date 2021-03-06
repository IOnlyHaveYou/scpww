package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 用户基本资料更新
 */
@Service
public class UpdateService {
    public UpdateService() {
        System.out.println("--------------------------UserService构造函数");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean UserUpdate(User user) {
        //更新时间设置
        user.setGenxingTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
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
