package com.service.module.user.controller;

import com.common.core.base.BaseController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.common.core.constant.ApiPathConstant.PATH_PREFIX_V1;

/**
 * <p>
 * 用户基础信息表 前端控制器
 * </p>
 *
 * @author yuanyixiong
 */
@Api(tags = {"UserBaseInfo"}, description = "用户基础信息表相关接口")
@RestController
@RequestMapping(PATH_PREFIX_V1 + "/userBaseInfo")
@Validated
@Slf4j
public class UserBaseInfoController extends BaseController {

}
