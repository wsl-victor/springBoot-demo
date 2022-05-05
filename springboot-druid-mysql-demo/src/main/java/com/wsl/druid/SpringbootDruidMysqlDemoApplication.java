package com.wsl.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@MapperScan("com.wsl.druid")
public class SpringbootDruidMysqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDruidMysqlDemoApplication.class, args);
    }

}
