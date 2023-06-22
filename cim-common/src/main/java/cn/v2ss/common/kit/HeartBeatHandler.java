package cn.v2ss.common.kit;

import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: YeFei
 * @Description: 心跳处理器
 * @Date: 2022-08-05 23:11
 **/
public interface HeartBeatHandler {

    /**
     * 处理心跳
     * @param ctx 上下文
     * @throws Exception
     */
    void process(ChannelHandlerContext ctx) throws Exception;
}
