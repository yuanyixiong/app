package com.gateway.server.result;

import lombok.Getter;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@Getter
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(0, "接口调用成功！"),

    /**
     * 接口调用失败
     */
    FAIL(-1, "接口调用失败"),

    /**
     * 请求参数异常
     */
    BAD_REQUEST(400, "请求参数异常"),

    /**
     * 未认证成功
     */
    UN_AUTH(401, "token认证失败"),
    /**
     * 方法不能访问
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    /**
     * 分享内容已失效
     */
    SHARE_LOSE_EFFICACY(406, "分享内容已失效,无法访问"),
    /**
     * 未认证成功
     */
    AUTH_OVERDUE(409, "token认证过期"),
    /**
     * 服务请求异常
     */
    SERVICE_ERROR(500, "服务请求异常");


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
