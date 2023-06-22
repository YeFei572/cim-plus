package cn.v2ss.common.route.algorithm;

import java.util.List;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-22 21:28
 **/
public interface RouteHandle {
    /**
     * 在一批服务器里进行路由
     * @param values
     * @param key
     * @return
     */
    String routeServer(List<String> values, String key);
}
