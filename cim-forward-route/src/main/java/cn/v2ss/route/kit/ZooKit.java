package cn.v2ss.route.kit;

import cn.v2ss.common.entity.RouteInfo;
import cn.v2ss.common.exception.CIMException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-22 22:10
 **/
@Slf4j
@Component
@RequiredArgsConstructor
public class ZooKit {
    private static final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    private final CuratorFramework curatorFramework;

    @Value("${route.zkRoot:/route}")
    private String zkRoot;

    /**
     * 监听事件
     */
    public void subscribeEvent() {
        CuratorCache nodeCache = CuratorCache.build(curatorFramework, zkRoot);
        nodeCache.start();
        nodeCache.listenable().addListener((type, oldData, data) -> {
            // 如果是初始化根节点，直接跳过监听
            if (!Objects.equals(data.getPath(), zkRoot)) {
                switch (type) {
                    case NODE_CREATED:
                        String addAddress = data.getPath().substring(data.getPath().indexOf("-") + 1);
                        cache.put(addAddress, addAddress);
                        log.info("最终放入安全集合数据为：{}", addAddress);
                        break;
                    case NODE_DELETED:
                        String delAddress = oldData.getPath().substring(oldData.getPath().indexOf("-") + 1);
                        cache.remove(delAddress);
                        log.info("最终删除安全集合数据为：{}", delAddress);
                        break;
                    default:
                        log.info("节点变化：oldData:{}, data:{}", oldData, data);
                }
            }
        });
    }

    /**
     * 获取所有节点
     *
     * @return 节点集合
     */
    public List<String> getAllNodes() {
        return new ArrayList<>(cache.values());
    }

    public void checkServerAvailable(RouteInfo info) {
        Boolean reachAble = NetAddressIsReachable.checkAddressReachable(info.getIp(), info.getServerPort(), 1000);
        if (!reachAble) {
            log.error("节点：{}，端口：{}当前不可用", info.getIp(), info.getServerPort());
            throw new CIMException("节点获取失败，请联系管理员查看！");
        }
    }

}
