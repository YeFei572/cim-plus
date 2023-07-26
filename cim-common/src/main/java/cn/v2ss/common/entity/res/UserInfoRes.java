package cn.v2ss.common.entity.res;

import cn.v2ss.common.entity.RouteInfo;
import lombok.Data;

@Data
public class UserInfoRes {
    private Long id;

    private String phone;

    private String token;

    private String nickname;

    private Integer gender;

    private String avatar;

    private String remark;

    private RouteInfo routeInfo;
}
