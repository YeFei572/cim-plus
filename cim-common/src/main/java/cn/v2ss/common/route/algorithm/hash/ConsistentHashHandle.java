package cn.v2ss.common.route.algorithm.hash;

import cn.v2ss.common.route.algorithm.RouteHandle;
import lombok.Setter;

import java.util.List;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-22 21:42
 **/
@Setter
public class ConsistentHashHandle implements RouteHandle {

    private AbstractConsistentHash hash;

    @Override
    public String routeServer(List<String> values, String key) {
        return hash.process(values, key);
    }
}
