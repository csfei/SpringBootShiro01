package com.cuisf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cuisf.dao")
public class SpringbootShiro01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiro01Application.class, args);
    }

}
