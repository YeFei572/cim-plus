package cn.v2ss.route.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.extra.spring.SpringUtil;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.kit.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CIMException.class)
    public BaseResponse<?> handleAllExceptions(CIMException ex) {
        BaseResponse<?> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ex.getErrorCode());
        baseResponse.setMessage(ex.getMessage());
        return baseResponse;
    }

    @ExceptionHandler(NotLoginException.class)
    public BaseResponse<?> handleNotLoginException(NotLoginException ex, HttpServletRequest req) {
        String ipAddress;
        if (req.getHeader("X-Forwarded-For") != null) {
            ipAddress = req.getHeader("X-Forwarded-For");
        } else {
            ipAddress = req.getRemoteAddr();
        }
        log.error("请求地址：{}， 没有登录，访问失败，来自ip:{}", req.getRequestURI(), ipAddress);
        return ResultUtils.fail(-1, "未登录，你请求个叼毛。");
    }
}
