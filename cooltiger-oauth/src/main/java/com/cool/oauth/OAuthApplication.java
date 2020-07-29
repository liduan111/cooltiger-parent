package com.cool.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/23 15:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OAuthApplication {
  public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class,args);
    }
}