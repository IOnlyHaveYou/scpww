package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.JiFenXiaoFei;
import com.trxk.scpww.pojo.JiFenXiaoFeiMapper;
import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class JiFenXiaoFeiService
{
   //积分详细情况对象
   @Value("#{new com.trxk.scpww.pojo.JiFenXiaoFei()}")
   JiFenXiaoFei jiFenXiaoFei;
    @Value("#{new java.util.HashMap()}")
    Map<String,String> map;

    //时间转换对象
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //注入JiFenXiaoFeiMapper
    @Autowired
    JiFenXiaoFeiMapper jiFenXiaoFeiMapper;

    List<Object> list;
    public Map<String,String> byUserIdChaXun(User user){
         //把userid注入到jifenxiaofei对象里面
        jiFenXiaoFei.setUserId(user.getId());
        try
        {
            //查询积分数据详情
            List<JiFenXiaoFei> jiFenXiaoFeiList = jiFenXiaoFeiMapper
                    .selectByUserId(jiFenXiaoFei);
            System.out.println(jiFenXiaoFeiList);
            for (JiFenXiaoFei jiFenXiaoFei1:jiFenXiaoFeiList){
                System.out.println("------jiFenXiaoFei1------"+jiFenXiaoFei1.getXiaoFeiJiFen());

                System.out.println("------jiFenXiaoFei1------"
                        +simpleDateFormat.format(jiFenXiaoFei1.getShiYongShiJian()));

                Object[] jifenxiangqing ={jiFenXiaoFei1.getXiaoFeiJiFen()
                        ,simpleDateFormat.format(jiFenXiaoFei1.getShiYongShiJian())};
                System.out.println(Arrays.toString(jifenxiangqing));

            }
            map.put("code","200");
            map.put("msg","查询成功");
            map.put("jiFen",""+list);
            return map;
        }catch (Exception e){
            map.put("code","200");
            map.put("msg","数据异常");
            return map;
        }


    }
}
