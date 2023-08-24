package cn.v2ss.server.controller;

import cn.v2ss.cn.server.ServerApi;
import cn.v2ss.common.entity.req.ChatDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("")
public class IndexController implements ServerApi {

    @Override
    @PostMapping("/sendMsg")
    public Object sendMsg(@RequestBody ChatDto dto) {
        log.info(dto.toString());
        return null;
    }
}
