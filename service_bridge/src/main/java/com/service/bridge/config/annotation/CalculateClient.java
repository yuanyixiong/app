package com.service.bridge.config.annotation;

import com.service.bridge.config.ServiceNameConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author 李琦
 * 推荐服务fegin client
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FeignClient(ServiceNameConstant.CALCULATE_SERVICE)
public @interface CalculateClient {

    @AliasFor(annotation = FeignClient.class, attribute = "fallbackFactory")
    Class<?> fallbackFactory() default void.class;

    @AliasFor(annotation = FeignClient.class, attribute = "path")
    String value() default "";

    @AliasFor(annotation = FeignClient.class, attribute = "primary")
    boolean primary() default true;
}
