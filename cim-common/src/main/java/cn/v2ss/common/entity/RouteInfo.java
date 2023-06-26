package cn.v2ss.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: YeFei
 * @Description: 路由信息
 * @Date: 2022-06-22 21:20
 **/
@Data
@Builder
@AllArgsConstructor
public final class RouteInfo {

    // 服务IP
    private String ip;
    // 服务端口
    private Integer serverPort;
    // 对外暴露http端口
    private Integer httpPort;
}
