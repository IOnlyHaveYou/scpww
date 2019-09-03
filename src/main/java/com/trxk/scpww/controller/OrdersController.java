package com.trxk.scpww.controller;



import com.trxk.scpww.pojo.Orders;
import com.trxk.scpww.pojo.ReturnBean;
import com.trxk.scpww.service.ordersservice.OrdersService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping(value = "/createOrders.action")
    @ResponseBody
    public Map<String,Object> createOrders(@RequestBody Map<String,Object> map){
        String order_id = UUID.randomUUID().toString().replace("-","");
        try {
            Orders orders = new Orders();
            BeanUtils.populate(orders,map);
            orders.setId(order_id);     //订单号
            orders.setCreateTime(new Date());
            orders.setPayType(0);       //先设置为0
            orders.setOrderState(0);    //设置为0
//            String userId = map.get("userId").toString();
            String[] passenger_ids = map.get("passenger_ids").toString().split(",");
            List<String> stringList = Arrays.asList(passenger_ids);
            ordersService.createOrders(orders,order_id,stringList);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("BeanUtils转型错误");
        }
        map = new HashMap<>();
        map.put("order_id",order_id);
        return map;
    }


    @RequestMapping(value = "/getOrderByOrderId.action")
    @ResponseBody
    public Orders getOrderByOrderId(@RequestBody Map<String,Object> map){
//        System.out.println("订单号："+map.get("order_id").toString());
        return ordersService.getOrderByOrderId(map.get("order_id").toString());
    }


    @RequestMapping(value = "/payByZfb.action")
    //工具类参数：String out_trade_no,String price,String subject,String body
    public void payByZfb(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        String form = ordersService.alipay(map.get("out_trade_no").toString(), map.get("price").toString()
                , map.get("subject").toString(), map.get("body").toString());
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(form);
    }


    @RequestMapping(value = "/payByJiFen.action")
    @ResponseBody
    public ReturnBean payByJiFen(@RequestBody Map<String,Object> map){
        //String order_id,String user_id,Integer jifen
        boolean action = ordersService.payByJiFen(map.get("order_id").toString(), map.get("user_id").toString()
                , Integer.parseInt(map.get("jifen").toString()));
        if(action){
            return new ReturnBean(200,"支付成功");
        }else {
            return new ReturnBean(500,"支付失败");
        }
    }


    @RequestMapping(value = "/ZfbPaySuccess.action")
    @ResponseBody
    public ReturnBean paySuccessByZfb(@RequestBody Map<String,Object> map) {
        ordersService.alipaySuccess(map.get("order_id").toString());
        return new ReturnBean(200, "支付成功");
    }


    @RequestMapping(value = "/searchOrder.action")
    @ResponseBody
    public List<Orders> searchOrder(@RequestBody Map<String,Object> map) {
        System.out.println(ordersService.searchOrder(map.get("startTime").toString(),map.get("endTime").toString()
                ,map.get("startStation").toString(),map.get("endStation").toString()));
        return ordersService.searchOrder(map.get("startTime").toString(),map.get("endTime").toString()
                ,map.get("startStation").toString(),map.get("endStation").toString());
    }
}
