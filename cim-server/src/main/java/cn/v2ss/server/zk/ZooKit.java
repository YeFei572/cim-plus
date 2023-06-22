package cn.v2ss.server.zk;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-09-06 21:55
 **/
@Slf4j
@Component
@RequiredArgsConstructor
public class ZooKit {

    private final CuratorFramework curatorFramework;

    // 创建父节点
    @SneakyThrows
    public void createRootNode() {
        Stat exist = curatorFramework.checkExists().forPath("/route");
        if (Objects.nonNull(exist)) {
            return;
        }
        // 创建持久节点
        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/route");
    }

    @SneakyThrows
    public void createNode(String path) {
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(path);
    }
}
