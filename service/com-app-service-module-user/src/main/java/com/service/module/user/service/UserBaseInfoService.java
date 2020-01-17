package com.service.module.user.service;

import com.common.core.service.BaseService;
import com.service.module.user.entity.UserBaseInfo;

/**
 * <p>
 * 用户基础信息表 服务类
 * </p>
 *
 * @author yuanyixiong
 */
public interface UserBaseInfoService extends BaseService<UserBaseInfo> {

    UserBaseInfo userInfo(Long userId);
}
