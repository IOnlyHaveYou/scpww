package com.trxk.scpww.service.ordersservice;



import com.trxk.scpww.dao.OrdersMapper;
import com.trxk.scpww.dao.UserMapper;
import com.trxk.scpww.pojo.Orders;
import com.trxk.scpww.utils.AliPayUtil;
import com.trxk.scpww.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)

    public void createOrders(Orders orders , String order_id , List<String> list){
       
        ordersMapper.insertOrders(orders);
        ordersMapper.insertOrdersPassenger(order_id,list);
    }


    public Orders getOrderByOrderId(String order_id){
        return ordersMapper.selectOrderByOrderId(order_id);
    }


    public String alipay(String out_trade_no,String price,String subject,String body){
        AliPayUtil aliPayUtil = new AliPayUtil();
        String successURL = "http://localhost:8080/html/paySuccess.html?order_id="+out_trade_no;     //支付完成(不是支付成功)跳转的页面
        return aliPayUtil.aliPay(successURL, Constant.FAST_INSTANT_TRADE_PAY, out_trade_no, price, subject, body);
    }


    public void alipaySuccess(String order_id){
        ordersMapper.updateOrderByPaySuccess(1,1,order_id);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean payByJiFen(String order_id,String user_id,Integer jifen){
        Integer user_jifen = userMapper.selectJiFenByUserId(user_id);
        if(user_jifen >= jifen){
            ordersMapper.updateOrderByPaySuccess(2,1,order_id);
            jifen = user_jifen - jifen;
            userMapper.updateJiFenByUserId(jifen,user_id);
            return true;
        }else{
            return false;
        }
    }


// ("startTime")String startTime,("endTime")String endTime,("startStation")String startStation,("endStation")String endStation
    public List<Orders> searchOrder(String startTime,String endTime,String startStation,String endStation){
        startTime = "".equals(startTime)?null:startTime;
        endTime = "".equals(endTime)?null:endTime;
        startStation = "".equals(startStation)?null:startStation;
        endStation = "".equals(endStation)?null:endStation;
        return ordersMapper.selectOrderBySearch(startTime, endTime, startStation, endStation);
    }
}
