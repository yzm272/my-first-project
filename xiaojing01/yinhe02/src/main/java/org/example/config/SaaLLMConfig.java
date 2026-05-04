package org.example.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaaLLMConfig {
 @Value("$spring.ai.dashscope.api-key")
 private String apikey;
@Bean
    public DashScopeApi dashScopeApi(){
    return DashScopeApi.builder().apiKey(apikey).build();
}
}
