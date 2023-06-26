package cn.v2ss.route.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "route")
public class RouteProperties {

    private String zkRoot;

    private String zkAddress;

    private Integer zkConnectTimeout;

    private String routeWay;

    private String consistentHashWay;
}
