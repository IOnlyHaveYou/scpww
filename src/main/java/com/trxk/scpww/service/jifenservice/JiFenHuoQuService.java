package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.JiFenHuoQu;
import com.trxk.scpww.pojo.JiFenHuoQuMapper;
import com.trxk.scpww.pojo.JiFenXiaoFei;
import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.WebServlet;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class JiFenHuoQuService
{
    //注入积分获取对象接口
    @Autowired
    JiFenHuoQuMapper jiFenHuoQuMapper;
    //注入积分获取对象
    @Value("#{new com.trxk.scpww.pojo.JiFenHuoQu()}")
    JiFenHuoQu jiFenHuoQu;
    //注入map对象
    @Value("#{new java.util.HashMap()}")
    Map<String,String> map;
    //时间转换对象
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<Object> list1 = new ArrayList<>();
    public Map<String,String> byUserIdChaXun(User user){
        //把userid注入到jifenxiaofei对象里面
        jiFenHuoQu.setUserId(user.getId());
        try
        {
            //查询积分数获取据详情
            List<JiFenHuoQu> List = jiFenHuoQuMapper
                    .selectByUserId(jiFenHuoQu);
            for (JiFenHuoQu list:List){
                //获取积分获取需要的的数据获取的积分和获取时间
                Object[] jifenxiangqing ={list.getHuoQuJiFen()
                        ,simpleDateFormat.format(list.getTime())};
                //把查询出来需要的获取积分数据详情注入List集合中
                list1.add( Arrays.toString(jifenxiangqing));
            }
            map.put("code","200");
            map.put("msg","查询成功");
            map.put("jiFenHuoQu",""+ list1);
            return map;
        }catch (Exception e){
            map.put("code","200");
            map.put("msg","数据异常");
            return map;
        }
    }
}
