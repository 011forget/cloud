package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * DATE: 2021/6/22
 * Author: ligang
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------- PaymentFallbackService FALLBACK paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------- PaymentFallbackService FALLBACK paymentInfo_TimeOut";
    }
}
