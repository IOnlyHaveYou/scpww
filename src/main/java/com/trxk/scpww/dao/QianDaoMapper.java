package com.trxk.scpww.dao;

import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.JiFenHuoQu;
import com.trxk.scpww.pojo.User;

/**
 * 签到Mapper
 */
public interface QianDaoMapper {
    User qianDao(User user);
    void updateQianDao(JiFen jiFen);
    void updateUser(User user);
    void jiFenAdd(JiFenHuoQu jiFenHuoQu);
}
