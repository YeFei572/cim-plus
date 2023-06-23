package cn.v2ss.cim.route.api.vo.res;

import cn.v2ss.common.entity.RouteInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class CIMServerResVO implements Serializable {

    private String ip;

    private Integer cimServerPort;

    private Integer httpPort;

    public CIMServerResVO(RouteInfo info) {
        this.ip = info.getIp();
        this.cimServerPort = info.getServerPort();
        this.httpPort = info.getHttpPort();
    }
}
