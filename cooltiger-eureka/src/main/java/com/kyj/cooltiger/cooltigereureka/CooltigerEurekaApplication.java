package com.kyj.cooltiger.cooltigereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication //springboot启动注解
@EnableEurekaServer
public class CooltigerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooltigerEurekaApplication.class, args);
    }

}
