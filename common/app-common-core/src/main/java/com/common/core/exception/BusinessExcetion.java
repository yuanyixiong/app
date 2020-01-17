package com.common.core.exception;


import com.common.pojo.result.CodeAndMessage;

/**
 * 业务异常
 */
public class BusinessExcetion extends RuntimeException {

    private CodeAndMessage codeAndMessage;

    public BusinessExcetion(CodeAndMessage codeAndMessage) {
        this.codeAndMessage = codeAndMessage;
    }

    public CodeAndMessage getCodeAndMessage() {
        return codeAndMessage;
    }
}
