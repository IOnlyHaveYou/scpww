package com.trxk.scpww.controller;

import com.trxk.scpww.utils.PostRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 从车票100查询车票
 */
@Controller
public class ChePiaoChaXueController {
    /**
     *传入搜索信息查询车票
     * @param map
     * @return
     */
    @RequestMapping(value = "/chePiaoChaXue", method = RequestMethod.POST)
    @ResponseBody
    public List<String> chePiaoChaXue(@RequestBody Map<String,String> map) {
        PostRequest postRequest = new PostRequest();
        map.put("userid","aa3642418@qq.com");
        map.put("seckey","3d162b170c84ea830360dd590985e7ba");
        List<String> list = new ArrayList<String>();
        // 车票100用户id
        list.add("userid");
        // 车票100用户授权码
        list.add("seckey");
        // 查询日期
        list.add("date");
        // 起始站
        list.add("startStation");
        // 终点站
        list.add("arriveStation");
        // http://www.chepiao100.com/api/yupiao
       String str  = postRequest.readHeader(map,"http://www.chepiao100.com/api/yupiao", list);
       list = new ArrayList<String>();
       list.add(str);
        return list;
    }

}