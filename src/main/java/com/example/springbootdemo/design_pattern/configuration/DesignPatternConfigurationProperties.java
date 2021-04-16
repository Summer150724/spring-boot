/**
 * 文件名：CustomApplicationConfig.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.configuration;

import com.example.springbootdemo.design_pattern.observer.observor.MyObserver;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 18:48
 * @description
 */
@Component
@ConfigurationProperties(prefix = "mycroft.config", ignoreInvalidFields = true)
@Data
public class DesignPatternConfigurationProperties {
    private Observer observer = new Observer();
    private Subject subject = new Subject();

    @Data
    public class Observer {
        private String name;
        @Deprecated
        private String ip;
        @DurationUnit(ChronoUnit.SECONDS)
        private Duration requestHeartBeat;

        @DeprecatedConfigurationProperty(reason = "change name", replacement = "none")
        public String getIp() {
            return ip;
        }
    }
    @Data
    public class Subject {
        private String name;
        private String ip;
    }
}
