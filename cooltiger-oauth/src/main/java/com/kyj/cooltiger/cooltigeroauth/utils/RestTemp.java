package com.kyj.cooltiger.cooltigeroauth.utils;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/31 14:01
 */
@Configuration
public class RestTemp {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return  builder.build();
    }

}
