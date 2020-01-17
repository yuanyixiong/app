package com.common.pojo.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据对象
     */
    private T data;

    public Result() {
    }

    public Result(T object) {
        this.data = object;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 如果result的data是Map类型 则可以通过此方法获取map对象
     *
     * @return Map对象
     */
    @SuppressWarnings({"uncheck"})
    public Map<String, Object> dataMap() {
        if (this.data instanceof Map) {
            return (Map<String, Object>) this.data;
        }
        return null;
    }
}
