package com.service.module.user.service.impl;

import com.common.core.service.impl.BaseServiceImpl;
import com.service.module.user.dao.UserBaseInfoMapper;
import com.service.module.user.entity.UserBaseInfo;
import com.service.module.user.service.UserBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户基础信息表 服务实现类
 * </p>
 *
 * @author yuanyixiong
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBaseInfoServiceImpl extends BaseServiceImpl<UserBaseInfoMapper, UserBaseInfo> implements UserBaseInfoService {

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Override
    public UserBaseInfo userInfo(Long userId) {
        return getById(userId);
    }
}
