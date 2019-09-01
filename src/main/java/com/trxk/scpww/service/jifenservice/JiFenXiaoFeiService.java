package com.trxk.scpww.service.jifenservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trxk.scpww.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class JiFenXiaoFeiService
{

    /**
     * 返回前端需要当前页面的数据包括(1.总共多少条 count，
     *                          2.总共多少页 allPage，
     *                          3.当前第几页 nowPage，
     *                          4.每页显示多少条 showCount,
     *                          5.当页的列表数据 list)
     */
   //积分详细情况对象
   @Value("#{new com.trxk.scpww.pojo.JiFenXiaoFei()}")
   JiFenXiaoFei jiFenXiaoFei;
   //创建一个Map对象
    @Value("#{new java.util.HashMap()}")
    Map<String,Object> map;
    //创建一个List集合对象
    @Value("#{new java.util.ArrayList()}")
    List<JiFenXiaoFei> list;
    //时间转换对象
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //注入JiFenXiaoFeiMapper
    @Autowired
    JiFenXiaoFeiMapper jiFenXiaoFeiMapper;
    public Map<String,Object> byUserIdChaXun(FenYe fenYe, Model model){
         //把userid注入到jifenxiaofei对象里面
        jiFenXiaoFei.setUserId(fenYe.getId());
        //引入PageHelper分页插件
        //查询之前需要调用,,传入页码，以及每页的大小
        PageHelper.startPage(fenYe.getNowPage(),fenYe.getShowCount());
        //startPage后面紧跟的是这个查询就是一个分页查询
        list= jiFenXiaoFeiMapper.selectByUserId(jiFenXiaoFei);
        //使用pageInfo包装查询后的结果，只需要将Pageinfo交给页面就行了
        //封装了详细的分页信息，包括我们查出来的数据,传入连续显示的数据
        PageInfo page = new PageInfo(list,fenYe.getShowCount());
        model.addAttribute("pageInfo",page);
        if(list != null){
            map.put("PageInfo",page);
        //这个位置传入的必须是list或者类型原型 不能是字符串 所有创建的map对象为Map<String,Object>
            map.put("page",list);
            map.put("code","200");
            map.put("msg","查询成功");
            return map;
        }else {
            map.put("code","200");
            map.put("msg","查询失败,数据异常");
            return map;
        }


    }
}
