package com.common.core.annotation;

import java.lang.annotation.*;

/**
 * @author 袁毅雄
 * @description 操作切割注解，用于标注在操作方法上，自动对参数进行切割
 * @date 2019/6/11
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationSub {


    /**
     * 操作最大数量，默认为200
     *
     * @return
     */
    int operationMaxNum() default 200;

}
