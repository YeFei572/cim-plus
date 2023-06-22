package cn.v2ss.server.zk;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: YeFei
 * @Description: 注册当前服务节点到zookeeper服务中去
 * @Date: 2022-09-06 21:53
 **/
@Slf4j
@RequiredArgsConstructor
public class RegistryZK implements Runnable {

    private ZooKit zooKit;

    private String ip;

    private int cimServerPort;

    private int httpPort;

    public RegistryZK(String ip, int cimServerPort, int httpPort) {
        this.ip = ip;
        this.cimServerPort = cimServerPort;
        this.httpPort = httpPort;
        zooKit = SpringUtil.getBean(ZooKit.class);
    }

    @Override
    public void run() {
        // 确认根节点，如果不存在直接创建
        zooKit.createRootNode();
        // 将本机注册到zookeeper
        String path = StrUtil.format("/route/ip-{}:{}:{}", ip, cimServerPort, httpPort);
        zooKit.createNode(path);
        log.info("本机注册到zookeeper成功：{}", path);
    }
}
