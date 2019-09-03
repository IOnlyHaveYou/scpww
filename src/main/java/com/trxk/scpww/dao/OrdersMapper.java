package com.trxk.scpww.dao;

import com.trxk.scpww.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    void insertOrders(Orders orders);
    void insertOrdersPassenger(@Param("order_id") String order_id, @Param("list") List<String> list);
    Orders selectOrderByOrderId(String order_id);
    void updateOrderByPaySuccess(@Param("pay_type") Integer pay_type, @Param("order_state") Integer order_state, @Param("order_id") String order_id);   //积分支付成功 修改订单状态、订单支付方式
    List<Orders> selectOrderBySearch(@Param("startTime") String startTime, @Param("endTime") String endTime
            , @Param("startStation") String startStation, @Param("endStation") String endStation);
}