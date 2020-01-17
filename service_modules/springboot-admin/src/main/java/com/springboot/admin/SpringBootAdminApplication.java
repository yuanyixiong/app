package com.springboot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableEurekaClient
@ComponentScan(basePackages= {"com.springboot.admin"})
public class SpringBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }

    @Bean
    @Primary
    public WebClient webClient(){
        return WebClient.builder()
                .build();
    }
}