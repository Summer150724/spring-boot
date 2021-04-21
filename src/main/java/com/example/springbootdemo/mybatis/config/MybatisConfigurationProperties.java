/**
 * 文件名：MybatisConfigurationProperties.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.mybatis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-21 14:33
 * @description
 */
@Component
@ConfigurationProperties(prefix = "mybatis.log")
public class MybatisConfigurationProperties {
    public Boolean intact;

    public Boolean getIntact() {
        return intact;
    }

    public void setIntact(Boolean intact) {
        this.intact = intact;
    }
}
