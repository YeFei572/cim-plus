package cn.v2ss.route;

import cn.v2ss.route.kit.ServerListListener;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-08-05 23:08
 **/
@Slf4j
@SpringBootApplication
@MapperScan("cn.v2ss.route.mapper")
public class RouteApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RouteApplication.class, args);
        log.info("路由服务器启动成功！！！！");
    }

    @Override
    public void run(String... args) {
        // 监听zk服务
        Thread thread = new Thread(new ServerListListener());
        thread.setName("zk-listener");
        thread.start();
    }
}
