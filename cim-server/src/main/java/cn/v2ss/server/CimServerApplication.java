package cn.v2ss.server;

import cn.v2ss.server.properties.AppProperties;
import cn.v2ss.server.zk.RegistryZK;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-09-06 21:49
 **/
@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@MapperScan("cn.v2ss.server.mapper")
public class CimServerApplication implements CommandLineRunner {

    private final AppProperties properties;
    @Value("${server.port:8084}")
    private int httpPort;

    public static void main(String[] args) {
        SpringApplication.run(CimServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 获得本机IP
        String address = InetAddress.getLocalHost().getHostAddress();
        log.info("当前节点ip：{}", address);
        Thread thread = new Thread(new RegistryZK(address, properties.getCimServerPort(), httpPort));
        thread.setName("register-zk");
        thread.start();
    }
}
