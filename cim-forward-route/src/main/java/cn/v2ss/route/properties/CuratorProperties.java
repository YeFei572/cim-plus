package cn.v2ss.route.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: YeFei
 * @Description: curator配置属性类
 * @Date: 2022-09-03 10:13
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "curator")
public class CuratorProperties {

    private int retryCount;

    private int elapsedTimeMs;

    private String connectString;

    private int sessionTimeoutMs;

    private int connectionTimeoutMs;
}
