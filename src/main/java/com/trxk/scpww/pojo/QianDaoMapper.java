package com.trxk.scpww.pojo;

/**
 * 签到Mapper
 */
public interface QianDaoMapper {
    User qianDao(User user);
    void updateQianDao(JiFen jiFen);
    void updateUser(User user);
    void jiFenAdd(JiFenHuoQu jiFenHuoQu);
}
