package cn.v2ss.server.controller;

import cn.v2ss.cn.server.ServerApi;
import cn.v2ss.common.entity.req.ChatDto;
import cn.v2ss.server.server.CIMServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class IndexController implements ServerApi {

    private final CIMServer cimServer;

    /**
     * 发送消息到指定用户
     *
     * @param dto 参数
     * @return 是否成功
     */
    @Override
    @PostMapping("/sendMsg")
    public Boolean sendMsg(@RequestBody ChatDto dto) {
        cimServer.sendMsg(dto);
        return Boolean.TRUE;
    }
}
