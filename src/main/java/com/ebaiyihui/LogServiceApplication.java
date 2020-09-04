package com.ebaiyihui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName LogServiceApplication
 * @description: 启动类
 * @author: liyp
 * @create: 2020-08-0717:03
 **/


@SpringBootApplication
@EnableMongoAuditing
@EnableAsync
public class LogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogServiceApplication.class, args);
    }
}