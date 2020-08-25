package com.ebaiyihui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * @ClassName LogServiceApplication
 * @description: 启动类
 * @author: liyp
 * @create: 2020-08-0717:03
 **/


@SpringBootApplication
@EnableMongoAuditing
public class LogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogServiceApplication.class, args);
    }
}