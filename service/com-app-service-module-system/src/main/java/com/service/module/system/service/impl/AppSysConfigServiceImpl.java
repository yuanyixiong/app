package com.service.module.system.service.impl;

import com.common.core.service.impl.BaseServiceImpl;
import com.service.module.system.dao.AppSysConfigMapper;
import com.service.module.system.entity.AppSysConfig;
import com.service.module.system.service.AppSysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 群组相关配置表 服务实现类
 * </p>
 *
 * @author yuanyixiong
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class AppSysConfigServiceImpl extends BaseServiceImpl<AppSysConfigMapper, AppSysConfig> implements AppSysConfigService {

}
