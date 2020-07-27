package com.kyj.cooltiger.cooltigerwateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CooltigerWatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooltigerWatewayApplication.class, args);
    }

}
