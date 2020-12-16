package com.myblog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lemoncc
 */
@ConfigurationProperties(prefix = "custom.config")
@Data
@Configuration
public class CustomConfig {

    /**
     * 不需要拦截的地址
     */
    private IgnoreConfig ignores;
}
