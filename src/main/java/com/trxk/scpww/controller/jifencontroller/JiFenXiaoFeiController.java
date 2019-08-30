package com.trxk.scpww.controller.jifencontroller;

import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.jifenservice.JiFenChaXunService;
import com.trxk.scpww.service.jifenservice.JiFenXiaoFeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 积分消费Controller
 */
@Controller
public class JiFenXiaoFeiController
{
    @Autowired
    JiFenXiaoFeiService jiFenXiaoFeiService;
    @RequestMapping(value = "/chaJiFenXiaoFei", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> byUserIdChaXun(@RequestBody(required = false) User user){
        return jiFenXiaoFeiService.byUserIdChaXun(user);
    }
}
