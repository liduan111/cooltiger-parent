package com.kyj.cooltiger.cooltigergoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CooltigerGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooltigerGoodsApplication.class, args);
    }

}
