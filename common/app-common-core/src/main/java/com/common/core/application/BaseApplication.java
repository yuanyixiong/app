package com.common.core.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.service.bridge.client.**"})
@ComponentScan(basePackages= {"com.**"})
@MapperScan("com.service.module.*.dao.**")
public class BaseApplication {
}

