package cn.v2ss.cn.client;

import cn.v2ss.cn.client.scanner.Scan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-10-02 17:04
 **/
@Slf4j
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        log.info("客户端启动成功！");
    }

    @Override
    public void run(String... args) throws Exception {
        Scan scan = new Scan();
        Thread thread = new Thread(scan);
        thread.setName("scan-thread");
        thread.start();

    }
}
