package cn.v2ss.common.entity.res;

import lombok.Data;

@Data
public class UserInfoRes {
    private Long id;

    private String phone;

    private String token;

    private String nickname;

    private Integer gender;

    private String remark;
}
