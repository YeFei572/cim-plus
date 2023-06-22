package cn.v2ss.common.entity.res;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-22 21:26
 **/
@Data
public class BaseResponse<T> implements Serializable {

    private Integer code;

    private String message;

    private String reqNo;

    private T data;

}
