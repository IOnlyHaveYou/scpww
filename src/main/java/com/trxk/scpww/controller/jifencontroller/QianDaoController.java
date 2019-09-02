package com.trxk.scpww.controller.jifencontroller;

import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.qianDaoService.QianDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class QianDaoController {

    @Autowired
    private QianDaoService qianDaoService;
    //签到验证
    @RequestMapping(value = "/qianDaos", method = RequestMethod.POST)
    @ResponseBody
    public String qianDao(@RequestBody JiFen jiFen){
        String id = jiFen.getUserId();
        System.out.println(id);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        User user = new User();
        user.setId(id);
        user.setGenXingTime(dateFormat.format(date));
        if(qianDaoService.updateQianDao(user,jiFen)) {
            return "false";
        }
        return "true";
    }
}
