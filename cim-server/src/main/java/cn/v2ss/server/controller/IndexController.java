package cn.v2ss.server.controller;

import cn.v2ss.cn.server.ServerApi;
import cn.v2ss.common.entity.req.ChatDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ServerApi {

    @PostMapping("/sendMsg")
    @Override
    public Object sendSmg(ChatDto dto) {
        return null;
    }
}
