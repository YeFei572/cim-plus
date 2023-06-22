package cn.v2ss.server.controller;

import cn.v2ss.common.entity.req.LoginReq;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.kit.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关处理器
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginReq req) {

        log.info(req.toString());
        return ResultUtils.ok("成功啦");
    }

}
