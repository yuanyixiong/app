package com.common.core.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * Redisson 配置
 *
 * @author 袁毅雄
 * @description
 * @date 2019/8/22
 */
@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 创建 redisson 连接
     * @return
     */
    @Bean
    @Primary
    public RedissonClient redissonClient() {
        Config config = new Config();
        final ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig
                .setScanInterval(200);

        final List<String> nodes = redisProperties.getCluster().getNodes();

        String ip = null;

        for (String ipPort : nodes) {
            clusterServersConfig.addNodeAddress("redis://" + ipPort);
        }
        clusterServersConfig.setPassword(redisProperties.getPassword());
        clusterServersConfig.setSubscriptionConnectionPoolSize(10);
        clusterServersConfig.setSlaveConnectionMinimumIdleSize(5);
        clusterServersConfig.setSlaveConnectionPoolSize(10);
        clusterServersConfig.setMasterConnectionMinimumIdleSize(5);
        clusterServersConfig.setMasterConnectionPoolSize(10);
        clusterServersConfig.setRetryAttempts(1);
        clusterServersConfig.setTimeout(1000);
        clusterServersConfig.setConnectTimeout(2000);
        clusterServersConfig.setFailedSlaveCheckInterval(1);
        clusterServersConfig.setFailedSlaveReconnectionInterval(1000);


        config.setThreads(8);
        config.setNettyThreads(16);

        return Redisson.create(config);
    }

}
