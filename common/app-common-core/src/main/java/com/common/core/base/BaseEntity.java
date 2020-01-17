package com.common.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 袁毅雄
 * @description 公共的entity
 * @date 2019/6/12
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = BaseEntity.ID)
    private Long id;

    @JsonIgnore
    @TableField(BaseEntity.CREATE_TIME)
    private Timestamp createTime;

    @JsonIgnore
    @TableField(BaseEntity.UPDATE_TIME)
    private Timestamp updateTime;

    @TableField(BaseEntity.CREATE_USER)
    private String createUser;

    @TableField(BaseEntity.UPDATE_USER)
    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getCreateTime() {
        return createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public final static String ID = "id";
    public final static String CREATE_USER = "create_user";
    public final static String CREATE_TIME = "create_time";
    public final static String UPDATE_USER = "update_user";
    public final static String UPDATE_TIME = "update_time";
}
