package com.service.bridge.fallback.system;

import com.service.bridge.client.system.SystemConfigRemoteClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * base info 远程服务错误回退类
 * 当远程服务调用异常之后，会调用该类进行处理
 */
@Component
@Slf4j
public class SystemConfigRemoteFallback implements FallbackFactory<SystemConfigRemoteClient> {

    @Override
    public SystemConfigRemoteClient create(Throwable throwable) {
        return new SystemConfigRemoteClient() {

            @Override
            public String getConfigByName(String configName) {
                log.error(String.format("SystemConfigRemoteClient getConfigByName error , configName = %s ", configName), throwable);
                return StringUtils.EMPTY;
            }
        };
    }
}
