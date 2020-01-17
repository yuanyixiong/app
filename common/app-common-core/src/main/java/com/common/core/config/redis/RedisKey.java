package com.common.core.config.redis;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/12
 */
public class RedisKey {
    /**
     * key的前缀
     */
    private String prefix;

    /**
     * prefix+key组成最终的键值
     */
    private String key;

    public RedisKey(String prefix) {
        this.prefix = prefix;
        this.key = "";
    }

    public RedisKey(String prefix, String key) {
        this.prefix = prefix;
        this.key = key;
    }

    public RedisKey(String prefix, Long key) {
        this.prefix = prefix;
        this.key = key.toString();
    }

    public static RedisKey of(String prefix, String key) {
        return new RedisKey(prefix, key);
    }

    public static RedisKey of(String prefix, Long key) {
        return new RedisKey(prefix, key);
    }

    public String getRealKey() {
        return prefix + "_" + key;
    }
}
