package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DATE: 2021/6/17
 * Author: ligang
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    //进行原子加1操作
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        log.info("*****next:"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
