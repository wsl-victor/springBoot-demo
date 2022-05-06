package com.wsl.rabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.wsl.rabbitmq.mail.mapper")
@EnableScheduling
@EnableAsync
public class SpringbootRabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitMqApplication.class, args);
    }

}
