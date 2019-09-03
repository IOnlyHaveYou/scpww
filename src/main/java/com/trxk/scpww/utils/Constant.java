package com.trxk.scpww.utils;

public class Constant {

/*
    车票接口相关常量
    登录http://www.chepiao100.com随便注册，查看接口需要传递的参数
 */
    public static final String TICKET_URI="http://www.chepiao100.com/api/yupiao";  //票务网站查询接口
    public static final String USER_ID="92121213@qq.com";                           //用户id
    public static final String SEC_KEY="1979737ef447fa1fb256bd2576a27afd";          //秘钥
/*
    支付宝相关常量
*/
    // 创建的应用ID
    public static final String APP_ID = "2016093000635202";
    // alipay测试支付地址
    public static final String ALI_PAY_DEV_URL = "https://openapi.alipaydev.com/gateway.do";
    // 自己APP的私钥
    public static final String MKEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCL5M2Ip25RAtOReI27F51rkZTr+UMl65MqUM1LBeb9wQ1ThuqjlauS1Z+m9v9qhFm0fhttbecOq0iBBkNgd4O4G+r9amPInQ9sYzA215Oi2lH9daNzAlELByRsi4dzLuUSyKyYlSOIHPNze1zOzRt0R9rsdWMbNc6LOoMs3WefxCOhoOKVKgcmnj4vxaWKaek+Ul+EjxBz3fX5d4iZt10NGgUvVOwYn/UF6xtNQyczykkap85BFywFDWPUwQ/Xe+H7B187AZMA7Qw7xT96Pg7NnP8jsWRkHbddpdTl416Sg6lCNWgO0v0iqNAIQZVrbifXNLxG+VhJbGZd/hedWhZhAgMBAAECggEAQmRJQ0Sq71mXDSAYq6VOeaGy+rbmrlV6F4gXljZr5Rw89do++3np3prx1Sy+FVBQvn9nBu00zlpt44YUbfDqm3LseG6Igso/aqI8XJq9H3nblZ3B/7AmxEQUfktN8lVcNCj2+Mc3AL80rybp6d+f2vTLKpOfgGdt6dfQL3e4WTLmg4LrEKOMQSfUrY9gHwCI96lATA6bkW8pdlc++p0kCtOe8IMY2nT6ZdBULfumVpSDgQGhINEGgNNby4u/+rWHDpj5a//lGJKYEyLuHxRLJ792Eip8cKnqS9YNun2Q0pTjIUj2vASA0IA0BHjFrLwO3lZ8pY3QjyAOdOak7UZDQQKBgQDoaSRsqoaSUUqpSCrs7VwXSnWOJMIjzWEmSxUM98Cngx5yPHTt9UuL+GXsVBZrDzmjv5cuHu4CITAuigJXGc61rhwwcapbWFlMLbOODBSSKyr2kzo5My3zIy9geGxNjpvxf9dlpMg/iottXY41Fw8DB7url6BVovjS8kFLY4JAmQKBgQCaF72mwMe/GfyG1+qLlp7SKCA2GWVNglLxRECDG3kJglCAH72E/Er2czRsepqrg8/l9msrqCnxYy+qp5EJblxwmy0T5Z5rqiCIA6QIenJ1XdIlIMMI06FYNeIws2YqjdAuKji9ltCqgdNrgEPMqpUXV3uK8ZWvr2BxYQMUzhn5CQKBgAqM01F3gDpeJFSA6SnuMHMCN0nnk0SKyzEw0VjQWleAVT58ThaLPw2wjffnbUkY3NX5GYTHdKh2FzjVnPuVOVP3/mGYl1IkNZGGtZLqK3jjKsUcs9Tq5NgXrcvkS45Nvfh9hCqiC1EPGfsx9wWj8VOC41sLvASHLGJvCtXAQ6ZpAoGAOzra7Ej3vo4XkiFWh3dK7w77arAST1vD0/dfMMYTnUMY/Fa2+3IawmaABR6Pa1QMSqGQikRmcuGkRd2JE233XFVZW2eMoGfRf1ae659ddZ2tlBXmwfLO9uAnZH7gy4SdO9GA4+cfqBqlEJJJ/VaoXkODOmIoHlK0KICYtZuPQjkCgYACYulifCn7BmLgUguqdFmgcxtoCTQOnAoJu5cIvCG3Sd5IycDcsAYVFxZYty/JQdAfqj86LvSVhPZLcBerjHlTqy9JZMAt9sJnY3VbsrY5mpqcooyDGHd1bPWclnYVU93O5kvMe/ZQzuo+Pz2ZdjAvHOOwm2u8moKtM2CLchs+aA==";
    // 支付宝的公钥(使用自己APP的公钥兑换)
    public static final String AKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi+TNiKduUQLTkXiNuxeda5GU6/lDJeuTKlDNSwXm/cENU4bqo5WrktWfpvb/aoRZtH4bbW3nDqtIgQZDYHeDuBvq/WpjyJ0PbGMwNteTotpR/XWjcwJRCwckbIuHcy7lEsismJUjiBzzc3tczs0bdEfa7HVjGzXOizqDLN1nn8QjoaDilSoHJp4+L8WlimnpPlJfhI8Qc931+XeImbddDRoFL1TsGJ/1BesbTUMnM8pJGqfOQRcsBQ1j1MEP13vh+wdfOwGTAO0MO8U/ej4OzZz/I7FkZB23XaXU5eNekoOpQjVoDtL9IqjQCEGVa24n1zS8RvlYSWxmXf4XnVoWYQIDAQAB";
    // 阿里支付正式接口
//    public static final String aliPayURL = "https://openapi.alipay.com/gateway.do";
    // 支付方式：代表扫码支付
    public static final String FAST_INSTANT_TRADE_PAY = "FAST_INSTANT_TRADE_PAY";
    // 支付方式：登录账号支付
    public static final String QUICK_WAP_PAY = "QUICK_WAP_PAY";
}
