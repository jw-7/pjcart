package com.pjcart.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.pjcart.shop.mapper"})
public class PjcartApplication {

    public static void main(String[] args) {
        SpringApplication.run(PjcartApplication.class, args);
    }

}
