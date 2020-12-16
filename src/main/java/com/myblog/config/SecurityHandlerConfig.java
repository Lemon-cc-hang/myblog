package com.myblog.config;

import com.myblog.common.lang.RspData;
import com.myblog.utils.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Security 结果处理配置
 * @author lemoncc
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return ((httpServletRequest, httpServletResponse, e) -> ResponseUtil.renderJson(httpServletResponse, RspData.RSP_CODE_ACCESS_DENIED, null, null));
    }
}
