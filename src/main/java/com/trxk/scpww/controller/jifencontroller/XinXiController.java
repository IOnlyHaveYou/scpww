package com.trxk.scpww.controller.jifencontroller;

import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.userService.XinXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 徐鹏
 * 常用联系人控制器
 */
@Controller
public class XinXiController {

    @Autowired
    XinXiService xinXiService;


    /**
     *
     * 根据id
     * @param mapId
     * @return
     */
   @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)

   @ResponseBody
    public Map<String,Object> selectByPrimaryKey(@RequestBody Map<String,String> mapId){
    String id = mapId.get("id");
       Map<String , Object > map = new HashMap<>();
//        System.out.println(id);

    if (xinXiService.selectByPrimaryKey(id)!= null){
    map.put("code","200");
    map.put("msg","查询成功");
    map.put("user", xinXiService.selectByPrimaryKey(id));
    }else{
        map.put("code","500");
        map.put("msg","查询失败");
    }
    return map;
}



    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)

    @ResponseBody
    public Map<String,Object> updateByPrimaryKey(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();

        if (xinXiService.updateByPrimaryKey(user)) {
            map.put("code", "200");
            map.put("msg", "更新成功");
            map.put("user", xinXiService.updateByPrimaryKey(user));
        } else {
            map.put("code", "500");
            map.put("msg", "更新失败");
        }
        return map;

    }
}
