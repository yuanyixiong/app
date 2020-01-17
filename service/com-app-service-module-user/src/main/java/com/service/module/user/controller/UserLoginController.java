package com.service.module.user.controller;

import com.common.core.base.BaseController;
import com.common.core.utils.SequenceUtil;
import com.common.pojo.result.Result;
import com.common.pojo.result.ResultUtil;
import com.service.module.user.entity.UserBaseInfo;
import com.service.module.user.service.UserBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.common.core.constant.ApiPathConstant.PATH_PREFIX_V1;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/12
 */
@Slf4j
@Validated
@RestController
@Api(tags = "用户登录相关接口")
@RequestMapping({PATH_PREFIX_V1 + "/auth"})
public class UserLoginController  extends BaseController {

    @Autowired
    private UserBaseInfoService userBaseInfo;

    @PostMapping("/tourist/login")
    @ApiOperation(value = "游客登录", response = UserBaseInfo.class, notes = "袁毅雄")
    public Result<UserBaseInfo> touristLogin() {
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        Long userId = SequenceUtil.getId();
        userBaseInfo.setId(userId);
        userBaseInfo.setUserNickName("游客");
        userBaseInfo.setUserSex(1);
        userBaseInfo.setUserType(3);
        log.info("user info log");
        return ResultUtil.success(userBaseInfo);
    }


    @PostMapping("/userInfo")
    @ApiOperation(value = "游客登录", response = UserBaseInfo.class, notes = "袁毅雄")
    public Result<UserBaseInfo> userInfo() {
        Long userId = getCurrentUserId();
        return ResultUtil.success(userBaseInfo.userInfo(userId));
    }
}
