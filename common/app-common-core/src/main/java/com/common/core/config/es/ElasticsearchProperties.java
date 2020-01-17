package com.common.core.config.es;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/6/11
 */
@Component
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class ElasticsearchProperties {

    private String username;

    private String password;

    private String nodes;

    private String prefix;

}
