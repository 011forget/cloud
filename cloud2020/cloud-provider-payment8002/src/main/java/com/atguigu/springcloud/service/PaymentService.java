package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * DATE: 2021/6/10
 * Author: ligang
 */
public interface PaymentService {
    int create(Payment payment);
    Payment paymentById(@Param("id") Long id);
}
