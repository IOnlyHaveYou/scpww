package com.trxk.scpww.pojo;

import java.util.List;

public interface JiFenMapper {

    //查询积分和消费积分关联查询
    List<JiFenXiaoFei> selectJiFen(JiFen jiFen);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jifen
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long jifenid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jifen
     *
     * @mbg.generated
     */
    int insert(JiFen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jifen
     *
     * @mbg.generated
     */
    int insertSelective(JiFen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jifen
     *
     * @mbg.generated
     */
    JiFen selectByUserId(JiFen jiFen);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jifen
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JiFen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jifen
     *
     * @mbg.generated
     */
    void updateByUserId(JiFen record);
}