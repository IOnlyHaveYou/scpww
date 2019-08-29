package com.trxk.scpww.controller;


import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    public UserController() {
        System.out.println("--------------------------UserAction构造函数");
    }

    @Autowired
    private LoginService loginService;
    @Autowired
    private RegService regService;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(@RequestBody User user){
        System.out.println("--------封装的user对象------"+user);
        Map<String ,String > map=new HashMap();
        Map<String ,String > map1=new HashMap<>();



        map.put("code","200");
        map.put("msg","登录成功");
        map.put("url","/user/index.html");

        map1.put("code","500");
        map1.put("msg","登录失败");
        map1.put("url","/user/pageerror.html");
        return loginService.Userlogin(user) ?
                map:map1;
//                "{code:200,msg:登录成功,url:/user/pagesuccess.html}":"{\"code\":500,\"msg\":\"登录失败\",\"url\":\"/user/pageerror.html\"}";
    }

    @RequestMapping(value = "/userreg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> reg(@RequestBody User user){
        System.out.println("--------封装的user对象------"+user);
        Map<String ,String > map=new HashMap();
        Map<String ,String > map1=new HashMap<>();



        map.put("code","200");
        map.put("msg","注册成功");
        map.put("url","/user/index.html");

        map1.put("code","500");
        map1.put("msg","注册失败");
        map1.put("url","/user/pageerror.html");
        return regService.userReg(user) ?
                map:map1;
//                "{code:200,msg:登录成功,url:/user/pagesuccess.html}":"{\"code\":500,\"msg\":\"登录失败\",\"url\":\"/user/pageerror.html\"}";
    }


}
