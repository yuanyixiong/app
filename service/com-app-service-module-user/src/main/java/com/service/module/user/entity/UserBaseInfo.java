package com.service.module.user.entity;

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
 * 用户基础信息表
 * </p>
 *
 * @author yuanyixiong
 */
@TableName("user_base_info")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBaseInfo extends BaseEntity {

    static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "用户头像")
    String userPic;

    @ApiModelProperty(notes = "用户昵称")
    String userNickName;

    @ApiModelProperty(notes = "用户性别:男-1;女-2")
    Integer userSex;

    @ApiModelProperty(notes = "用户类型:真实用户-1;马甲用户-2;游客-3;")
    Integer userType;

    @ApiModelProperty(notes = "是否有效:有效-1;无效-0")
    Integer isValid;

}
