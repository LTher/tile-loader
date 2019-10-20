package com.lhq.loader.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lhq.loader.bean.SysConfig;

/**
 * @author 灯火
 *
 */
@Configuration
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "config")
    public Map<String, String> sysConfigMap() {
        return new HashMap<>();
    }

    @Bean
    public SysConfig sysConfig(@Qualifier("sysConfigMap") Map<String, String> sysConfigMap) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setMaxTask(Integer.parseInt(sysConfigMap.get("maxTask")));
        sysConfig.setMongoStore(Integer.parseInt(sysConfigMap.get("mongoStore")));
        sysConfig.setRetryNum(Integer.parseInt(sysConfigMap.get("retryNum")));
        sysConfig.setTilePoolSize(Integer.parseInt(sysConfigMap.get("tilePoolSize")));
        return sysConfig;
    }

}