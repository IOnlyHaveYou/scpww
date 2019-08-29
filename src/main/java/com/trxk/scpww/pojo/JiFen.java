package com.trxk.scpww.pojo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class JiFen {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jifen.jifenid
     *
     * @mbg.generated
     */
    private Long jifenid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jifen.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jifen.ji_fen
     *
     * @mbg.generated
     */
    private Long jiFen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jifen.geng_xin_time
     *
     * @mbg.generated
     */
    private Date gengXinTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jifen.xiao_fei_jin_e
     *
     * @mbg.generated
     */
    private Long xiaoFeiJinE;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jifen.ji_fen_jin_e
     *
     * @mbg.generated
     */
    private Long jiFenJinE;

    //传入JiFenXiaoFeiMapper
    private List<JiFenXiaoFeiMapper> JiFenXiaoFeiMapperLiset;

    public List<JiFenXiaoFeiMapper> getJiFenXiaoFeiMapperLiset()
    {
        return JiFenXiaoFeiMapperLiset;
    }

    public void setJiFenXiaoFeiMapperLiset(List<JiFenXiaoFeiMapper> jiFenXiaoFeiMapperLiset)
    {
        JiFenXiaoFeiMapperLiset = jiFenXiaoFeiMapperLiset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jifen.jifenid
     *
     * @return the value of jifen.jifenid
     *
     * @mbg.generated
     */
    public Long getJifenid() {
        return jifenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jifen.jifenid
     *
     * @param jifenid the value for jifen.jifenid
     *
     * @mbg.generated
     */
    public void setJifenid(Long jifenid) {
        this.jifenid = jifenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jifen.user_id
     *
     * @return the value of jifen.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jifen.user_id
     *
     * @param userId the value for jifen.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jifen.ji_fen
     *
     * @return the value of jifen.ji_fen
     *
     * @mbg.generated
     */
    public Long getJiFen() {
        return jiFen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jifen.ji_fen
     *
     * @param jiFen the value for jifen.ji_fen
     *
     * @mbg.generated
     */
    public void setJiFen(Long jiFen) {
        this.jiFen = jiFen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jifen.geng_xin_time
     *
     * @return the value of jifen.geng_xin_time
     *
     * @mbg.generated
     */
    public Date getGengXinTime() {
        return gengXinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jifen.geng_xin_time
     *
     * @param gengXinTime the value for jifen.geng_xin_time
     *
     * @mbg.generated
     */
    public void setGengXinTime(Date gengXinTime) {
        this.gengXinTime = gengXinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jifen.xiao_fei_jin_e
     *
     * @return the value of jifen.xiao_fei_jin_e
     *
     * @mbg.generated
     */
    public Long getXiaoFeiJinE() {
        return xiaoFeiJinE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jifen.xiao_fei_jin_e
     *
     * @param xiaoFeiJinE the value for jifen.xiao_fei_jin_e
     *
     * @mbg.generated
     */
    public void setXiaoFeiJinE(Long xiaoFeiJinE) {
        this.xiaoFeiJinE = xiaoFeiJinE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jifen.ji_fen_jin_e
     *
     * @return the value of jifen.ji_fen_jin_e
     *
     * @mbg.generated
     */
    public Long getJiFenJinE() {
        return jiFenJinE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jifen.ji_fen_jin_e
     *
     * @param jiFenJinE the value for jifen.ji_fen_jin_e
     *
     * @mbg.generated
     */
    public void setJiFenJinE(Long jiFenJinE) {
        this.jiFenJinE = jiFenJinE;
    }
}