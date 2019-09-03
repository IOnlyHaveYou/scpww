package com.trxk.scpww.pojo;

public class ReturnBean {
    private Integer code;
    private String msg;

    public ReturnBean() {
    }

    public ReturnBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
