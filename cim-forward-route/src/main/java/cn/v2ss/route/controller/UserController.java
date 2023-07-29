package cn.v2ss.route.controller;

import cn.v2ss.common.entity.req.LoginReq;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.entity.res.UserInfoRes;
import cn.v2ss.common.kit.ResultUtils;
import cn.v2ss.route.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关接口
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 登录接口
     *
     * @param req 登录参数封装类
     * @return 登陆结果返回参数
     */
    @PostMapping("/login")
    public BaseResponse<UserInfoRes> login(@RequestBody LoginReq req) {
        log.info("用户{}开始登录，密码为：{}", req.getPhone(), req.getPassword());
        UserInfoRes userInfo = userService.login(req);
        return ResultUtils.ok(userInfo);
    }

    /**
     * 注册接口
     *
     * @param req 注册参数封装类
     * @return 是否注册成功
     */
    @PostMapping("/register")
    public BaseResponse<Boolean> register(@RequestBody LoginReq req) {
        return ResultUtils.ok(userService.register(req), "注册成功！");
    }

}
