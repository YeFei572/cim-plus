package cn.v2ss.route.controller;

import cn.v2ss.common.entity.req.P2PReq;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.kit.ResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @PostMapping("/p2p")
    public BaseResponse<?> p2pRouter(@Validated @RequestBody P2PReq req) {
        return ResultUtils.ok(null);
    }
}
