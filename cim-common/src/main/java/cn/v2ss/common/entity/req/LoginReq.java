package cn.v2ss.common.entity.req;

import lombok.Data;

@Data
public class LoginReq {

    private String phone;

    private String password;
}
