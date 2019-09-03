package com.trxk.scpww.controller.jifencontroller;


import com.trxk.scpww.pojo.FenYe;
import com.trxk.scpww.pojo.JiFenXiaoFei;
import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.jifenservice.JiFenChaXunService;
import com.trxk.scpww.service.jifenservice.JiFenXiaoFeiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 积分消费Controller
 */
@Controller
public class JiFenXiaoFeiController
{
    @Autowired
    JiFenXiaoFeiService jiFenXiaoFeiService;
    @Value("#{new java.util.HashMap()}")
    Map<String,Object> map;
    @Value("#{new java.util.ArrayList()}")
    List<JiFenXiaoFei> list;
    @RequestMapping(value = "/chaJiFenXiaoFei", method = RequestMethod.POST)

    @ResponseBody

    /**
     * 传入前端传过来的需要分多少页,当前是第几页
     */
    public Map<String,Object> byUserIdChaXun(@RequestBody(required = false)FenYe fenYe, Model model){

        System.out.println(fenYe);
        return jiFenXiaoFeiService.byUserIdChaXun(fenYe,model);
    }
}
