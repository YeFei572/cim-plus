package cn.v2ss.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-17 23:36
 **/
@Getter
@AllArgsConstructor
public enum StatusEnum {
    /**
     * 成功
     */
    SUCCESS(9000, "成功"),

    /**
     * 成功
     */
    FALLBACK(8000, "FALL_BACK"),

    /**
     * 参数校验失败
     **/
    VALIDATION_FAIL(3000, "invalid argument"),

    /**
     * 失败
     */
    FAIL(4000, "Failure"),

    /**
     * 重复登录
     */
    REPEAT_LOGIN(5000, "Repeat login, log out an account please!"),

    /**
     * 请求限流
     */
    REQUEST_LIMIT(6000, "请求限流"),

    /**
     * 账号不在线
     */
    OFF_LINE(7000, "你选择的账号不在线，请重新选择！"),

    SERVER_NOT_AVAILABLE(7100, "cim server is not available, please try again later!"),

    RECONNECT_FAIL(7200, "Reconnect fail, continue to retry!"),

    /**
     * 登录信息不匹配
     */
    ACCOUNT_NOT_MATCH(9100, "The User information you have used is incorrect!");


    /**
     * 枚举值码
     */
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * 得到枚举值码。
     * @return 枚举值码。
     */
    public Integer code() {
        return code;
    }

    /**
     * 得到枚举描述。
     * @return 枚举描述。
     */
    public String message() {
        return message;
    }


}
