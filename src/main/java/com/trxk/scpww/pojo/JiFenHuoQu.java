package com.trxk.scpww.pojo;

import java.util.Date;

public class JiFenHuoQu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ji_fen_huo_qu.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ji_fen_huo_qu.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ji_fen_huo_qu.huo_qu_ji_fen
     *
     * @mbg.generated
     */
    private Integer huoQuJiFen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ji_fen_huo_qu.time
     *
     * @mbg.generated
     */
    private Date time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ji_fen_huo_qu.id
     *
     * @return the value of ji_fen_huo_qu.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ji_fen_huo_qu.id
     *
     * @param id the value for ji_fen_huo_qu.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ji_fen_huo_qu.user_id
     *
     * @return the value of ji_fen_huo_qu.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ji_fen_huo_qu.user_id
     *
     * @param userId the value for ji_fen_huo_qu.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ji_fen_huo_qu.huo_qu_ji_fen
     *
     * @return the value of ji_fen_huo_qu.huo_qu_ji_fen
     *
     * @mbg.generated
     */
    public Integer getHuoQuJiFen() {
        return huoQuJiFen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ji_fen_huo_qu.huo_qu_ji_fen
     *
     * @param huoQuJiFen the value for ji_fen_huo_qu.huo_qu_ji_fen
     *
     * @mbg.generated
     */
    public void setHuoQuJiFen(Integer huoQuJiFen) {
        this.huoQuJiFen = huoQuJiFen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ji_fen_huo_qu.time
     *
     * @return the value of ji_fen_huo_qu.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ji_fen_huo_qu.time
     *
     * @param time the value for ji_fen_huo_qu.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }
}