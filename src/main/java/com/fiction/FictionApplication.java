package com.fiction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(basePackages = {"com.fiction.mapper"})
public class FictionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FictionApplication.class, args);
    }

}
