package cn.v2ss.route.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.v2ss.cn.server.ServerApi;
import cn.v2ss.common.entity.req.ChatDto;
import cn.v2ss.common.constant.Constants;
import cn.v2ss.common.entity.RouteInfo;
import cn.v2ss.common.entity.req.P2PReq;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.kit.RedisUtils;
import cn.v2ss.common.kit.ResultUtils;
import cn.v2ss.common.proxy.ProxyManager;
import cn.v2ss.common.util.RouteInfoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.v2ss.route.constant.Constant.ROUTE_PREFIX;

/**
 * 发送消息的相关接口
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final OkHttpClient client;

    /**
     * 单聊
     *
     * @param req 单聊参数
     * @return 是否成功
     */
    @PostMapping("/p2p")
    public BaseResponse<?> p2pRouter(@Validated @RequestBody P2PReq req) {
        // 开始获取用户的路由信息
        String receiveServer = RedisUtils.getCacheObject(ROUTE_PREFIX + req.getReceiveUserId());
        if (StringUtils.isBlank(receiveServer)) {
            throw new CIMException("对方不在线！");
        }
        // 准备参数进行发送
        ChatDto chatDto = new ChatDto(req.getReceiveUserId(), req.getMsg());
        long userId = StpUtil.getLoginIdAsLong();
        return ResultUtils.ok(null);
    }


    private void pushMsg(String server, Long sendUserId, ChatDto dto) {
        RouteInfo routeInfo = RouteInfoUtils.parse(server);
        String url = Constants.HTTP + routeInfo.getIp() + Constants.COLON + routeInfo.getHttpPort();
        ServerApi instance = new ProxyManager<>(ServerApi.class, url, client).getInstance();
        Response response = null;
        try {
            response = (Response) instance.sendSmg(dto);
        } catch (Exception e) {
            log.error("发送失败：{}", e.getMessage());
        } finally {
            if (null != response && null != response.body()) {
                response.body().close();
            }
        }
    }
}
