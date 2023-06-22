package cn.v2ss.common.kit;

import cn.v2ss.common.entity.res.BaseResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultUtils {

    public static <T> BaseResponse<T> ok(T data) {
        BaseResponse<T> resp = new BaseResponse<T>();
        resp.setData(data);
        resp.setCode(0);
        resp.setMessage("成功");
        return resp;
    }

    public static <T> BaseResponse<T> ok(T data, String msg) {
        BaseResponse<T> resp = new BaseResponse<T>();
        resp.setData(data);
        resp.setCode(0);
        resp.setMessage(msg);
        return resp;
    }

    public static <T> BaseResponse<T> fail(Integer code, String msg) {
        BaseResponse<T> resp = new BaseResponse<T>();
        resp.setData(null);
        resp.setCode(code);
        resp.setMessage(msg);
        return resp;
    }

    public static <T> BaseResponse<T> fail(String msg) {
        BaseResponse<T> resp = new BaseResponse<T>();
        resp.setData(null);
        resp.setCode(-1);
        resp.setMessage(msg);
        return resp;
    }
}
