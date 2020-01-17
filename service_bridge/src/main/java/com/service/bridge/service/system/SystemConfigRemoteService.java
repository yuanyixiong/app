package com.service.bridge.service.system;

import com.service.bridge.config.ServicePathConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 袁毅雄
 * @description 系统配置远程服务定义接口
 * @date 2019/8/22
 */
@RequestMapping(ServicePathConstant.PATH_V1 + "/config")
public interface SystemConfigRemoteService {

    /**
     * 根据配置名查询配置值
     *
     * @param configName
     */
    @GetMapping("/getConfigByName")
    String getConfigByName(@RequestParam("configName") String configName);
}
