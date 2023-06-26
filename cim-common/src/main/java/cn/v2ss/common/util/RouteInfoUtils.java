package cn.v2ss.common.util;

import cn.v2ss.common.entity.RouteInfo;
import cn.v2ss.common.exception.CIMException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RouteInfoUtils {

    public RouteInfo parse(String info) {
        try {
            String[] serverInfo = info.split(":");
            return RouteInfo.builder()
                    .ip(serverInfo[0])
                    .serverPort(Integer.parseInt(serverInfo[1]))
                    .httpPort(Integer.parseInt(serverInfo[2]))
                    .build();
        } catch (Exception e) {
            throw new CIMException("路由解析失败，请联系管理人员查看！");
        }
    }
}
