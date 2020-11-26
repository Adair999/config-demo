package com.txw.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@SuppressWarnings("all")
@RestController
@RequestMapping
public class HystrixController {
    /**
     * 使用线程池限流
     */
    @RequestMapping(value = "/testQPS1", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "THREAD"),
                    // 线程超时时间
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1000"),
                    // 设置超时的时候是否中断线程
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_INTERRUPT_ON_TIMEOUT, value = "false")
            }
    )
    public String testQPS1() {
        try {
            System.out.println(Thread.currentThread().getId() + "：testQPS1执行休眠前");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + "：testQPS1执行休眠后");
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return "ok";
    }
    public String flowError(){
        System.out.println("当前访问人数过多，请稍后重试");
        return "当前访问人数过多，请稍后重试";
    }
    /**
     * 使用信号量限流
     */
    @RequestMapping(value = "/testQPS2", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod = "flowError",
            commandProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"),
                    // 线程超时时间
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "5000"),
                    // 设置超时的时候是否中断线程
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "3")
            }
    )
    public String testQPS2() {
        try {
            System.out.println(Thread.currentThread().getId() + "：testQPS2执行休眠前");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId() + "：testQPS2执行休眠后");
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return "ok";
    }
}