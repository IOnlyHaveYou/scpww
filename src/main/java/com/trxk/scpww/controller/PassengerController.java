package com.trxk.scpww.controller;


import com.trxk.scpww.pojo.Passenger;
import com.trxk.scpww.service.userService.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    /*
    查询常用联系人
     */
    @RequestMapping(value = "/displayPassenger",method = RequestMethod.POST)

    @ResponseBody
    public Map<String,Object> selectPassenger(@RequestBody Map<String , String> mapId){
        String id = mapId.get("userId");
        Map<String,Object> map = new HashMap<>();
        System.out.println(id);
        if (passengerService.selectAllByPrimaryKey(id) != null){
            map.put("code","200");
            map.put("msg","查询成功");
            map.put("passenger",passengerService.selectAllByPrimaryKey(id));
        }
        else{
            map.put("code","500");
            map.put("msg","查询失败");
        }
        System.out.println(map);
        return map;
}
    /*
    新增常用联系人
     */
    @RequestMapping(value = "/addPassenger",method = RequestMethod.POST)

    @ResponseBody
    public Map<String,String> inertPassenger(@RequestBody Passenger passenger ){


        System.out.println("---------"+passenger);

        Map<String,String> map = new HashMap();
        Passenger passenger1 = passengerService.selectPassengerByPassengernameAndIdentityNumber(passenger);
        if(passenger1 != null){
            map.put("code","520");
            map.put("msg","常用乘车人已存在");
        }else {
            if (passengerService.insert(passenger) == true) {
                map.put("code", "200");
                map.put("msg", "新增成功");
            } else {
                map.put("code", "500");
                map.put("msg", "新增失败");
            }
        }
        return map;
    }


    /*
    删除联系人
     */
    @RequestMapping(value = "/deleltPassenger",method = RequestMethod.POST)

    @ResponseBody
    public Map<String,String> deletePassenger(@RequestBody Map<String , String> mapId ){
        String id = mapId.get("id");
        Map<String,String> map = new HashMap();

        if (passengerService.deleteByPrimaryKey(id) == true){
            map.put("code","200");
            map.put("msg","删除成功");
        }
        else{
            map.put("code","500");
            map.put("msg","删除失败");
        }
        return map;
    }

/*
更新联系人
 */
@RequestMapping(value = "/updatePassenger",method = RequestMethod.POST)

@ResponseBody
public Map<String,String> updatePassenger(@RequestBody Passenger passenger ){

    Map<String ,String> map = new HashMap<>();

    if (passengerService.updatepassenger(passenger)){
        map.put("code","200");
        map.put("msg","更新成功");
    }
    else{
        map.put("code","500");
        map.put("msg","更新失败");
    }
    return map;
}

    @RequestMapping(value = "/selectPassenger",method = RequestMethod.POST)

    @ResponseBody
    public Map<String ,String> selectPassengerByPassengernameAndIdentityNumber(@RequestBody Passenger passenger ){

        Map<String ,String> map = new HashMap<>();
        if(passengerService.selectPassengerByPassengernameAndIdentityNumber(passenger) == null){

            map.put("code","200");
            map.put("msg","数据库无记录");
        }
        else{
            map.put("code","500");
            map.put("msg","数据库有记录");
        }
        return map;
    }


}
