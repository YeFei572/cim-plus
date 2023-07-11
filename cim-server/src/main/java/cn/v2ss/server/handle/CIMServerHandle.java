package cn.v2ss.server.handle;

import cn.v2ss.cn.server.api.protocol.RequestProto;
import cn.v2ss.common.constant.Constants;
import cn.v2ss.common.enums.MsgTypeEnum;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.kit.RedisUtils;
import cn.v2ss.server.util.UserUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-09-17 01:11
 **/
@Slf4j
@ChannelHandler.Sharable
public class CIMServerHandle extends SimpleChannelInboundHandler<RequestProto.BaseRequestProto> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            // 读空闲
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                // 关闭用户连接 TODO
            }
        }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("抓到异常啦：{}", cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestProto.BaseRequestProto msg) {
        int type = msg.getType();
        // 如果是登录信息
        if (MsgTypeEnum.LOGIN.getCode().equals(type)) {
            // 检查用户的token是否合法
            Object currentUserId = RedisUtils.getCacheObject(Constants.USER_TOKEN_KEY + msg.getReqMsg());
            if (Objects.isNull(currentUserId) || StringUtils.isBlank(String.valueOf(currentUserId)) || !currentUserId.toString().equals(String.valueOf(msg.getRequestId()))) {
                // 组装失败消息
                RequestProto.BaseRequestProto req = RequestProto.BaseRequestProto.newBuilder()
                        .setRequestId(1L)
                        .setReqMsg("登录失败，token无效！")
                        .setType(MsgTypeEnum.LOGIN.getCode()).build();
                ctx.channel().writeAndFlush(req);
            } else {
                UserUtils.put(msg.getRequestId(), (NioSocketChannel) ctx.channel());
                log.info("登录成功！");
            }
        }
        String reqMsg = msg.getReqMsg();
        long requestId = msg.getRequestId();
        log.info("收到的消息：{}, 消息类型是：{}，消息id是：{}", reqMsg, type, requestId);
        log.info("toString:{}", msg.toBuilder().getReqMsg());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("来自客户端的请求，准备建立连接。。");
        super.channelActive(ctx);
    }
}
