package com.service.module.system.controller;

import com.common.pojo.result.Result;
import com.common.pojo.result.ResultUtil;
import com.google.common.collect.Lists;
import com.service.bridge.service.user.UserAuthRemoteService;
import com.service.module.system.service.AppSysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.common.core.constant.ApiPathConstant.PATH_PREFIX_V1;

/**
 * @author 袁毅雄
 * @description 系统配置
 * @date 2019/6/11
 */
@Api(tags = "系统配置")
@RestController
@RequestMapping({PATH_PREFIX_V1 + "/system/config"})
@Slf4j
public class SystemConfigController {

    @Autowired
    private UserAuthRemoteService userAuthRemoteService;

    @Autowired
    private AppSysConfigService appSysConfigService;

    @GetMapping(value = "/config/value")
    @ApiOperation(value = "获取配置信息", response = String.class, notes = "袁毅雄")
    public Result getConfigValue(@ApiParam(name = "configName", value = "配置名", required = true) @RequestParam(value = "configName") String configName) {
        log.info("system info log");
        return ResultUtil.success(String.format("%s,%s", "Hello", configName));
    }

    @GetMapping(value = "/bridge/user")
    @ApiOperation(value = "跨服务调用use", response = String.class, notes = "袁毅雄")
    public Result bridgeServiceUser(@ApiParam(name = "configName", value = "配置名", required = true) @RequestParam(value = "configName") String configName) {
        return ResultUtil.success(userAuthRemoteService.getRealNameByUserIds(Lists.newArrayList(1L)));
    }


}
