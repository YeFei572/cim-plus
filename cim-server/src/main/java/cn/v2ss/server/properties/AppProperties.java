package cn.v2ss.server.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-09-06 22:34
 **/
@Data
@Configuration
@ConfigurationProperties("app")
public class AppProperties {

    private String zkRoot;

    private String zkAddress;

    private Boolean zkSwitch;

    private int cimServerPort;

    private String routeUrl;
}
