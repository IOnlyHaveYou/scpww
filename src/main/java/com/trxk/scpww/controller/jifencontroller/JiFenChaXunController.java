package com.trxk.scpww.controller.jifencontroller;

import com.sun.javafx.collections.MappingChange;
import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.JiFenXiaoFei;
import com.trxk.scpww.pojo.User;
import com.trxk.scpww.service.jifenservice.JiFenChaXunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *积分查询Controller
 */
@Controller
public class JiFenChaXunController
{
    //
    @Autowired
    JiFenChaXunService jiFenChaXunService;
    @RequestMapping(value = "/chaXunJiFen", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> byUserIdChaXun(@RequestBody (required = false) User user){
        return jiFenChaXunService.byUserIdChaXun(user);
    }


}
