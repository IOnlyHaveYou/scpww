package com.trxk.scpww.controller;


import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.userService.*;
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
    @Autowired
    private QueryService queryService;
    @Autowired
    private UpdateService updateService;
    @Autowired
    private CheckService checkService;

    //用户登录
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(@RequestBody User user) {
        System.out.println("--------封装的user对象------" + user);
        Map<String, String> map = new HashMap();
        user = loginService.Userlogin(user);

        if (user != null) {
            map.put("code", "200");
            map.put("msg", "登录成功");
            map.put("url", "/user/index.html");
            map.put("id", user.getId());
            map.put("username", user.getUsername());
        } else {
            map.put("code", "500");
            map.put("msg", "登录失败");
            map.put("url", "/user/pageerror.html");
        }

        return map;
    }

    //重名检测
    @RequestMapping(value = "/usercheck", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> userCheck(@RequestBody Map<String, String> username) {
        System.out.println("前台传进来的username-------" + username);

        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();

        map.put("code", "200");
        map.put("msg", "该用户名可用");

        map1.put("code", "500");
        map1.put("msg", "该用户名已存在");
        return regService.userCheckReg(username.get("username")) ?
                map : map1;
    }

    //用户注册
    @RequestMapping(value = "/userreg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> reg(@RequestBody User user) {
        System.out.println("--------封装的user对象------" + user);
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();


        map.put("code", "200");
        map.put("msg", "注册成功");
        map.put("url", "/user/login.html");

        map1.put("code", "500");
        map1.put("msg", "注册失败");
        map1.put("url", "/user/pageerror.html");
        return regService.userReg(user) ?
                map : map1;
    }

    //用户基本资料查询
    @RequestMapping(value = "/userSelect", method = RequestMethod.POST)
    @ResponseBody
    public Map userQuery(@RequestBody Map<String, String> user) {
        System.out.println("--------封装的user对象------" + user);
        Map map = new HashMap();
        User user1 = queryService.userQuery(user.get("userId"));
        if (user1 != null) {

            map.put("code", "200");
            map.put("msg", "查询成功");
            map.put("username", user1.getUsername());
            map.put("realname", user1.getRealname());
            map.put("telephone", user1.getTelephone());
            map.put("userIdentity",user1.getUserIdentity());
//        map.put("url","/user/login.html");
        } else {
            map.put("code", "500");
            map.put("msg", "查询失败");
            map.put("url", "/user/pageerror.html");
        }
        return map;
    }
    //用户信息修改
    @RequestMapping(value = "/userupdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> userUpdate(@RequestBody User user) {
        System.out.println("--------封装的user对象------" + user);
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();


        map.put("code", "200");
        map.put("msg", "修改成功");

        map1.put("code", "500");
        map1.put("msg", "修改失败");
        return updateService.UserUpdate(user) ?
                map : map1;
    }

    //修改密码 原密码检查
    @RequestMapping(value = "/checkpassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> passwordCheck(@RequestBody User user) {

        System.out.println("--------封装的user对象------" + user);
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();


        map.put("code", "200");
        map.put("msg", "原密码匹配");

        map1.put("code", "500");
        map1.put("msg", "原密码错误, 请重行输入");
        return checkService.checkPassword(user) ?
                map : map1;


    }
    //修改密码
    @RequestMapping(value = "/modifypassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> passwordModify(@RequestBody User user) {

        System.out.println("--------封装的user对象------" + user);
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();


        map.put("code", "200");
        map.put("msg", "修改成功");

        map1.put("code", "500");
        map1.put("msg", "修改失败");
        return updateService.passwordUpdate(user) ?
                map : map1;


    }
}
