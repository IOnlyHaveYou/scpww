package com.trxk.scpww.controller.jifencontroller;

import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.jifenservice.JiFenChaXunService;
import com.trxk.scpww.service.jifenservice.JiFenHuoQuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 积分获取Controller
 */
@Controller
public class JiFenHuoQuController
{
    @Autowired
    JiFenHuoQuService jiFenHuoQuService;
    @RequestMapping(value = "/chaXunJiFenHuoQu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> byUserIdChaXun(@RequestBody(required = false) User user){
        return jiFenHuoQuService.byUserIdChaXun(user);
    }
}