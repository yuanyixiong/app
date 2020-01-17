package com.service.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.core.base.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;


/**
 * <p>
 * 群组相关配置表
 * </p>
 *
 * @author yuanyixiong
 */
@TableName("app_sys_config")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppSysConfig extends BaseEntity {

    static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "配置名称")
    String configName;

    @ApiModelProperty(notes = "配置描述")
    String configDesc;

    @ApiModelProperty(notes = "配置值")
    String configValue;

}
