package com.service.module.user.resource;


import com.service.bridge.service.user.UserAuthRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Maps;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 袁毅雄
 * @description 远程资源实现类
 * @date 2019/8/22
 */
@Slf4j
@RestController
public class UserAuthRemoteResource implements UserAuthRemoteService {

    @Override
    public Map<Long, String> getRealNameByUserIds(List<Long> userIds) {
        return Maps.newHashMap(1L, "袁毅雄");
    }
}
