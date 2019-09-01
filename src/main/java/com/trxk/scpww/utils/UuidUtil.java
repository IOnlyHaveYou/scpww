package com.trxk.scpww.utils;

import java.util.UUID;

public class UuidUtil
{
    public String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
