package cn.v2ss.common.entity.req;

import lombok.Data;

/**
 * 登录参数
 */
@Data
public class LoginReq {

    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
}
