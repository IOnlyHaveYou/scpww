package com.trxk.scpww.dao;

import com.trxk.scpww.pojo.JiFenHuoQu;

import java.util.List;

public interface JiFenHuoQuMapper {

    List<JiFenHuoQu> selectByUserId(JiFenHuoQu jiFenHuoQu);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ji_fen_huo_qu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ji_fen_huo_qu
     *
     * @mbg.generated
     */
    int insert(JiFenHuoQu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ji_fen_huo_qu
     *
     * @mbg.generated
     */
    int insertSelective(JiFenHuoQu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ji_fen_huo_qu
     *
     * @mbg.generated
     */
    JiFenHuoQu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ji_fen_huo_qu
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JiFenHuoQu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ji_fen_huo_qu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JiFenHuoQu record);
}