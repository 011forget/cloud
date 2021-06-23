package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * DATE: 2021/6/21
 * Author: ligang
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Ok，Id："+id;
    }

    /**
     * 带延时的
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHander",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_Timeout(Integer id){
        int timeOut = 0;
        try{
            TimeUnit.SECONDS.sleep(timeOut);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        //int age = 10/0;
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Timrout，Id："+id;
    }

    public String paymentInfo_TimeOutHander(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHander"+"/(ㄒoㄒ)/~~";
    }
}
