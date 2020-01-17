package com.gateway.server.service;

import com.gateway.server.bean.LogInfo;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */

public interface LogService {


    /**
     * 保存日志信息
     *
     * @param logInfo
     */
    void saveLog(LogInfo logInfo);

}

