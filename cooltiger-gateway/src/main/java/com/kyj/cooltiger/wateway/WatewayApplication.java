package com.kyj.cooltiger.wateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatewayApplication.class, args);
    }

}
