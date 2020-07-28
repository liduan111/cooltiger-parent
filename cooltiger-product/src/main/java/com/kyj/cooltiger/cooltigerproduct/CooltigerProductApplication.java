package com.kyj.cooltiger.cooltigerproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kyj.cooltiger.cooltigerproduct.mapper")
public class CooltigerProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooltigerProductApplication.class, args);
    }

}

