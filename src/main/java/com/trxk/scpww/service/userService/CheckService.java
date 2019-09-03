package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 用户修改密码, 原密码匹配检测
 */
@Service
public class CheckService {
    public CheckService() {
        System.out.println("--------------------------UserService构造函数");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean checkPassword(User user) {
        boolean action = false;
        User user01 = userMapper.selectByPrimaryKey(user.getId());
        System.out.println("密码----------------------"+user01);
        if (user01.getPassword().equals(user.getPassword())) {
            action = true;
        }

        return action;

    }
}
