package com.gateway.server.bean;

import lombok.Data;

/**
 * @author 袁毅雄
 * @description 注册或登录返回数据
 * @date 2019/6/11
 */
@Data
public class LoginAndRegisterResult {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户手机号
     */
    private String cellphone;

    /**
     * 用户头像
     */
    private String userPic;

    /**
     * 用户性别:男-1;女-2
     */
    private Integer userSex;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户学校id
     */
    private String schoolId;

    /**
     * 是否绑定了手机号
     */
    private Integer isSkipCellphone;
}