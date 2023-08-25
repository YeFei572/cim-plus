package cn.v2ss.common.entity.res;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用封装类
 *
 * @param <T> 泛型
 */
@Data
public class BaseResponse<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 请求编号
     */
    private String reqNo;
    /**
     * 具体的data
     */
    private T data;

}
