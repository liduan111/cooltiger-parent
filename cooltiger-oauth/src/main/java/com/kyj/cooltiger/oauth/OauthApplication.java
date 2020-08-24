package com.kyj.cooltiger.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/23 15:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.kyj.cooltiger.feign.*"})
public class OauthApplication {
  public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class,args);
    }
}