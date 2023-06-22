package cn.v2ss.route.handler;

import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.exception.CIMException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CIMException.class)
    public BaseResponse<?> handleAllExceptions( CIMException ex) {
        BaseResponse<?> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ex.getErrorCode());
        baseResponse.setMessage(ex.getMessage());
        return baseResponse;
    }
}
