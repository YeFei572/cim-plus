package cn.v2ss.server.handle;

import cn.v2ss.cn.server.api.protocol.RequestProto;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

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
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RequestProto.BaseRequestProto msg) {
        int type = msg.getType();
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
