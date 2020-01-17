package com.common.pojo.enums;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/8/22
 */
public enum BaseEnum {

    /**
     * 是否有效(有效)
     */
    IS_VALID_YES(1, "是否有效(有效)"),
    /**
     * 是否有效(无效)
     */
    IS_VALID_NO(0, "是否有效(无效)"),
    /**
     * 是否上架(未上架)
     */
    IS_SHELF_NO(0, "是否上架(未上架)"),
    /**
     * 是否上架(已上架)
     */
    IS_SHELF_YES(1, "是否上架(已上架)"),
    /**
     * 是否发布(未发布)
     */
    IS_PUBLISH_NO(0, "是否发布(未发布)"),
    /**
     * 是否发布(已发布)
     */
    IS_PUBLISH_YES(1, "是否发布(已发布)"),
    /**
     * 是否置顶(置顶)
     */
    IS_TOP_YES(1, "是否置顶(置顶)"),
    /**
     * 是否置顶(不置顶)
     */
    IS_TOP_NO(0, "是否置顶(不置顶)"),;


    private Integer key;
    private String description;

    BaseEnum(Integer key, String description) {
        this.key = key;
        this.description = description;
    }

    public Integer getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
