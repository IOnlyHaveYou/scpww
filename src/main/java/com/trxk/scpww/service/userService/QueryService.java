package com.trxk.scpww.service.userService;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 用户基本资料查询
 */
@Service
public class QueryService {
    public QueryService() {
        System.out.println("--------------------------UserService构造函数");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public User userQuery(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        System.out.println("dhlfjlsdfldj---------" + user);
        return user;

    }
}
