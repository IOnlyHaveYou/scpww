package com.trxk.scpww.service.userService;

import com.trxk.scpww.pojo.Passenger;
import com.trxk.scpww.dao.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PassengerService {


    /**
    通过主键id获取passenger展示前段
     */
    @Autowired
    PassengerMapper passengerMapper;
    public  List<Passenger> selectAllByPrimaryKey(String id){

        List<Passenger> passenger = passengerMapper.selectAllByPrimaryKey(id);
        System.out.println(passenger);
        return passenger;
    }


    public  Passenger selectByPrimaryKey(String id){

        Passenger passenger = passengerMapper.selectByPrimaryKey(id);
        System.out.println(passenger);
        return passenger;
    }
    /**
    新增常用乘车人
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Passenger passenger){
        boolean action = false;
        passenger.setId(UUID.randomUUID().toString().replace("-",""));
        passengerMapper.insert(passenger);
        action = true;
    return action;
    }

    /**
    删除常用乘车人
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByPrimaryKey(String id){

    boolean action = false;
    passengerMapper.deleteByPrimaryKey(id);
    action = true;
    return action;
    }

    /**
    更新常用乘车人
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updatepassenger(Passenger passenger){

        boolean action = false;
        passengerMapper.updateByPrimaryKey(passenger);
        action = true;
        return action;
    }

    /**
     * 根据常用乘车人姓名和身份证查询常用乘车人
     * @param passenger 常用乘车人
     * @return 查询出来的常用乘车人
     */
    public Passenger selectPassengerByPassengernameAndIdentityNumber(Passenger passenger) {
          return passengerMapper.selectPassengerByPassengernameAndIdentityNumber(passenger);

    }
}
