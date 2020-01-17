package com.common.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.core.base.BaseMapper;
import com.common.core.service.BaseService;


/**
 * @author 袁毅雄
 * @description 公共service实现
 * @date 2019/6/12
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

}
