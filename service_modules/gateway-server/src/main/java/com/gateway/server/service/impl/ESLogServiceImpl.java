package com.gateway.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gateway.server.bean.LogInfo;
import com.gateway.server.result.Result;
import com.gateway.server.result.ResultEnum;
import com.gateway.server.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@Service("esLogService")
@Slf4j
public class ESLogServiceImpl implements LogService {

    private static final String SERVICE_NAME = "service-module-es";

    private static final String SERVICE_MAPPING = "/resource/v1/sync/log/create";

    @Resource(name = "lbWebClient")
    private WebClient webClient;

    @Override
    public void saveLog(LogInfo logInfo) {
        webClient.post().uri("http://".concat(SERVICE_NAME).concat(SERVICE_MAPPING))
                .body(Mono.just(logInfo), LogInfo.class)
                .retrieve()
                .bodyToMono(Result.class)
                .doOnError(WebClientResponseException.class, err -> {
                    log.error("保存请求log到ES中失败,status:{},msg:{}", err.getRawStatusCode(), err.getResponseBodyAsString());
                })
                .subscribe(e -> {
                    if (e.getCode() != ResultEnum.SUCCESS.getCode()) {
                        log.error("保存请求log到ES中失败，结果为: {}", JSONObject.toJSONString(e));
                    } else {
                        log.info("保存請求log到es , result = {} ", JSONObject.toJSONString(e));
                    }
                }, err -> {
                    log.error("保存请求log到ES中失败 ", err);
                });

    }
}
