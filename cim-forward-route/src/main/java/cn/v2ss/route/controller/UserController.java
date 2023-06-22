package cn.v2ss.route.controller;

import cn.v2ss.common.entity.req.LoginReq;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.entity.res.UserInfoRes;
import cn.v2ss.common.kit.ResultUtils;
import cn.v2ss.route.kit.ZooKit;
import cn.v2ss.route.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: YeFei
 * @Description: 路由控制器
 * @Date: 2022-09-17 00:25
 **/
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ZooKit zooKit;

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginReq req) {
        log.info("用户{}开始登录，密码为：{}", req.getPhone(), req.getPassword());
        UserInfoRes userInfo = userService.login(req);
        List<String> res = zooKit.getAllNodes();
        log.info("zk的节点有这些：{}", res);
        return ResultUtils.ok(userInfo);
    }

    @PostMapping("/register")
    public BaseResponse<Boolean> register(@RequestBody LoginReq req) {
        return ResultUtils.ok(userService.register(req), "注册成功！");
    }
}
