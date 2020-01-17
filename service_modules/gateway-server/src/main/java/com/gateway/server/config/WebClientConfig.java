package com.gateway.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@Configuration
public class WebClientConfig {


    @Autowired
    private LoadBalancerExchangeFilterFunction lbFunction;

    @Bean("lbWebClient")
    public WebClient lbWebClient() {
        return WebClient.builder()
                .filter(lbFunction)
                .build();
    }

    @Bean
    @Primary
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }


}