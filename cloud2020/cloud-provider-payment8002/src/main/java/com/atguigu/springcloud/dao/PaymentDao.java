package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DATE: 2021/6/10
 * Author: ligang
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment paymentById(@Param("id") Long id);
}
