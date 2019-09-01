package com.trxk.scpww.service.qianDaoService;

import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.JiFenHuoQu;
import com.trxk.scpww.pojo.QianDaoMapper;
import com.trxk.scpww.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class QianDaoService{
    public QianDaoService(){
        System.out.println("-----------QianDaoService构造函数-----------");
    }

    @Autowired
    private QianDaoMapper qianDao;

    @Transactional(rollbackFor = Exception.class)
    public boolean updateQianDao(User user, JiFen jiFen) {
        if(qianDao.qianDao(user) == null ){
            System.out.println(user.getId());
            qianDao.updateQianDao(jiFen);
            qianDao.updateUser(user);
            JiFenHuoQu jiFenHuoQu = new JiFenHuoQu();
            String id = user.getId();
            jiFenHuoQu.setUserId(id);
            qianDao.jiFenAdd(jiFenHuoQu);
            return true;
        }
        return false;
    }


}
