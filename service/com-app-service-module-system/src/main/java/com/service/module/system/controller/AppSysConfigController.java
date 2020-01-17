package com.service.module.system.controller;

import com.common.core.base.BaseController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.common.core.constant.ApiPathConstant.PATH_PREFIX_V1;

/**
 * <p>
 * 群组相关配置表 前端控制器
 * </p>
 *
 * @author yuanyixiong
 */
@Api(tags = {"AppSysConfig"}, description = "群组相关配置表相关接口")
@RestController
@RequestMapping(PATH_PREFIX_V1 + "/appSysConfig")
@Validated
@Slf4j
public class AppSysConfigController extends BaseController {

}
