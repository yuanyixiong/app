package com.service.module.system.resource;

import com.service.bridge.service.system.SystemConfigRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 袁毅雄
 * @description 远程资源实现类
 * @date 2019/8/22
 */
@Slf4j
@RestController
public class SystemConfigRemoteResource implements SystemConfigRemoteService {

    @Override
    public String getConfigByName(String configName) {
        return "我是配置";
    }
}
