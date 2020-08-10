package com.ebaiyihui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName LogServiceApplication
 * @description: 启动类
 * @author: liyp
 * @create: 2020-08-0717:03
 **/


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.ebaiyihui.patient"})
public class LogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogServiceApplication.class, args);
    }
}