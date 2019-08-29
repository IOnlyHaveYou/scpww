package com.trxk.scpww.service.jifenservice;

import com.trxk.scpww.pojo.JiFen;
import com.trxk.scpww.pojo.JiFenMapper;
import com.trxk.scpww.pojo.JiFenXiaoFei;
import com.trxk.scpww.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JiFenChaXunService
{
    JiFen jiFen = new JiFen();
    @Autowired
    JiFenMapper jiFenMapper;
    public List<JiFenXiaoFei> byUserIdChaXun(String  id){
        jiFen.setUserId(id);
    /*public JiFen byUserIdChaXun(User user){
        jiFen.setUserId(user.getId());*/
        System.out.println(jiFen);
        System.out.println(jiFenMapper.selectJiFen(jiFen));
        return jiFenMapper.selectJiFen(jiFen);
    }

    public static void main(String[] args)
    {
        System.out.println(new JiFenChaXunService()
                .byUserIdChaXun("919e7e12d65542b9b3f4a9088d90deea"));
    }
}
