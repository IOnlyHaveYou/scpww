package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.JiFenMapper;
import com.trxk.scpww.pojo.Orders;
import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JiFenService
{
    //更新用户积分
    @Autowired
    JiFenMapper jiFenMapper;
    JiFen jiFen = new JiFen();
    public boolean jiFenUpdate(Orders orders){
        JiFen jiFen1= jiFenMapper.selectByUserId(jiFen);
        if(jiFenMapper.selectByUserId(jiFen) !=null)
        {
            //最新的消费总金额
            double price = jiFen1.getXiaoFeiJinE() + orders.getTicketPrice();
            //积分金额
            double price1 = jiFen1.getJiFenJinE();
            //每100元加1积分,addJiFen是能加的积分数
            int addJiFen = (int) (price - price1)/100;
            //最新的积分
            jiFen.setJiFen(jiFen1.getJiFen() + addJiFen);
            jiFen.setXiaoFeiJinE((long) price);
            jiFen.setJiFenJinE((long) price1 + addJiFen * 100);
            jiFenMapper.updateByUserId(jiFen);
            return true;
        }else{
            return false;
        }
    }

    //创建新用户积分数据
    public  void insertUser(User user){
        jiFen.setUserId(user.getId());
        jiFenMapper.insert(jiFen);
    }

    //测试类
    public static void main(String[] args)
    {
}
}
