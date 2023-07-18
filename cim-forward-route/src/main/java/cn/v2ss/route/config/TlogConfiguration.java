package cn.v2ss.route.config;

import com.yomahub.tlog.springboot.TLogWebAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 日志配置类
 *
 * @author Protected User
 * @date 2023/07/18 10:58
 **/
@Configuration
@EnableAutoConfiguration(exclude = TLogWebAutoConfiguration.class)
public class TlogConfiguration {
}
