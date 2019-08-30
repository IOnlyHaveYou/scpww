package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class JiFenHuoQuService
{

    @Value("#{new java.util.HashMap()}")
    Map<String,String> map;
    public Map<String,String> byUserIdChaXun(User user){
        return map;
    }
}
