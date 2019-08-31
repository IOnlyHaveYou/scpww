package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.*;
import com.trxk.scpww.utill.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JiFenChaXunService
{

    //jifen对象
    @Value("#{new com.trxk.scpww.pojo.JiFen()}")
    JiFen jiFen;

    //创建一个map对象
    @Value("#{new java.util.HashMap()}")
    Map<String,String> map;
    //时间转换对象
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //注入JiFenMapper
    @Autowired
    JiFenMapper jiFenMapper;

    public Map<String,String> byUserIdChaXun(User user){

        System.out.println("这是传过来的user"+user);
        //把userid注入到jifen对象里面
        jiFen.setUserId(user.getId());
        try
        {
            //查询积分数据
            JiFen jiFen1= jiFenMapper.selectUserId(jiFen);
            if(jiFen1.getJiFen() ==null ){
                map.put("code","200");
                map.put("msg","查询成功");
                map.put("jiFen",""+0);
                return map;
            }else {
                map.put("code","200");
                map.put("msg","查询成功");
                map.put("jiFen",""+jiFen1.getJiFen());
                return map;
            }
        }catch (Exception e){
            map.put("code","200");
            map.put("msg","数据异常");
            return map;
        }
    }

    public static void main(String[] args)
    {

    }
}
