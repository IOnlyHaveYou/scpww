package com.trxk.scpww.utill;

import java.util.UUID;

public class uuidUtil
{
    public String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
