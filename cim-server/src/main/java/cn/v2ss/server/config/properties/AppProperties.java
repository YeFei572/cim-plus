package cn.v2ss.server.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 服务启动配置类
 */
@Data
@Component
@ConfigurationProperties("app")
public class AppProperties {
    // 内网ip
    private String nodeIntranetIp;
    // 节点公网ip
    private String nodeExtranetIp;

    private String zkRoot;

    private String zkAddress;

    private Boolean zkSwitch;

    private int cimServerPort;

    private String routeUrl;
}
