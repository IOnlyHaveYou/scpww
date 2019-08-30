package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.*;
import com.trxk.scpww.utill.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JiFenChaXunService
{
    @Value("#{new com.trxk.scpww.utill.UuidUtil()}")
    UuidUtil uuidUtil;

    //jifen对象
    @Value("#{new com.trxk.scpww.pojo.JiFen()}")
    JiFen jiFen;

    //积分详细情况对象
    @Value("#{new com.trxk.scpww.pojo.JiFenXiaoFei()}")
    JiFenXiaoFei jiFenXiaoFei;
    //创建一个map对象
    @Value("#{new java.util.HashMap()}")
    Map<String,String> map;
    //注入JiFenMapper
    @Autowired
    JiFenMapper jiFenMapper;
    //注入JiFenXiaoFeiMapper
    @Autowired
    JiFenXiaoFeiMapper jiFenXiaoFeiMapper;
    public Map<String,String> byUserIdChaXun(User user){

        System.out.println("这是传过来的user"+user);
        //把userid注入到jifen对象里面
        jiFen.setUserId(user.getId());
        //把userid注入到jifenxiaofei对象里面
        jiFenXiaoFei.setUserId(user.getId());
        try
        {
            //查询积分数据
            JiFen jiFen1= jiFenMapper.selectUserId(jiFen);
            //查询积分数据详情
            List<JiFenXiaoFei> jiFenXiaoFeiList = jiFenXiaoFeiMapper
                    .selectByUserId(jiFenXiaoFei);
            map.put("code","200");
            map.put("msg","查询成功");
            map.put("jiFen",""+jiFen1);
            map.put("jiFenXiaoFei",""+jiFenXiaoFeiList);
            return map;
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
