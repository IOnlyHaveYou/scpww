package com.trxk.scpww.utils;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class AliPayUtil {
    //导入依赖  alipay-sdk-java
    /**
     * 传递指定的参数内容，完成对应的支付规则
     * @param successURL           支付完成(不是支付成功)跳转的页面
     * @param product_code         支付方式
     * @param out_trade_no         订单号
     * @param price                 订单总价格
     * @param subject               商品的内容
     * @param body                  商品的描述
     * @return                      返回阿里支付服务器中的form表单字符串
     */
    public String aliPay(String successURL, String product_code, String out_trade_no,
                         String price, String subject, String body) {
        AlipayClient alipayClient = new DefaultAlipayClient(Constant.ALI_PAY_DEV_URL,
                Constant.APP_ID, Constant.MKEY, "json", "utf-8", Constant.AKEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();    // 创建API对应的request
        // 当调用接口成功，返回的页面
//        alipayRequest.setReturnUrl("http://localhost:8080/success.html");
        alipayRequest.setReturnUrl(successURL);
        // 在公共参数中设置回跳和通知地址(必须在公网IP)
        alipayRequest.setNotifyUrl("http://localhost:8080/payReturnServlet");

//        String out_trade_no = out_trade_no;              // 每笔订单号需要自身的唯一id，支付宝会根据此id判断是否交易
//        String product_code = AliPayFiled.FAST_INSTANT_TRADE_PAY;        // 支付方式：FAST_INSTANT_TRADE_PAY扫码支付
//        String total_amount = "13886.88";                       // 这笔订单的价格
//        String subject = "IphoneXXXXXSSSSS 1TB";               // 订单商品名称
//        String body = "这是一个用肾换来的电话";                 // 订单商品描述

        String bizContent = "{" +
                "\"out_trade_no\":\"" + out_trade_no + "\"," +
                "\"product_code\":\"" + product_code + "\"," +
                "\"total_amount\":" + price + "," +
                "\"subject\":\"" + subject + "\"," +
                "\"body\":\"" + body + "\"}";                               // 生成支付json数据
        System.out.println("支付生成json数据 bizContent=" + bizContent);    // 打印json支付数据

        alipayRequest.setBizContent(bizContent);                             // 提交支付请求

        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();        //调用SDK生成表单，发起阿里服务器请求
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}
