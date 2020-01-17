package com.service.bridge.fallback.user;

import com.google.common.collect.Maps;
import com.service.bridge.client.user.UserAuthRemoteClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanghao
 * @date 2019/4/26 16:25
 **/
@Component
@Slf4j
public class UserAuthRemoteFallback implements FallbackFactory<UserAuthRemoteClient> {
    @Override
    public UserAuthRemoteClient create(Throwable throwable) {
        return new UserAuthRemoteClient() {
            @Override
            public Map<Long, String> getRealNameByUserIds(List<Long> userIds) {
                log.error(String.format("UserAuthRemoteClient getRealNameByUserIds error , userIds = %s ", userIds), throwable);
                return Maps.newHashMap();
            }
        };
    }
}
