package cn.v2ss.server.config;

import com.yomahub.tlog.springboot.TLogWebAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = TLogWebAutoConfiguration.class)
class TlogConfiguration {

}