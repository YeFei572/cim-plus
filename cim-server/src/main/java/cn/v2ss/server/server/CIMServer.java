package cn.v2ss.server.server;

import cn.v2ss.server.config.properties.AppProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @Author: YeFei
 * @Description: netty 服务器
 * @Date: 2022-09-17 01:05
 **/
@Slf4j
@Component
@RequiredArgsConstructor
public class CIMServer {

    private final AppProperties appProperties;

    private final EventLoopGroup boss = new NioEventLoopGroup();
    private final EventLoopGroup work = new NioEventLoopGroup();

    /**
     * 默认启动Netty服务
     * @throws InterruptedException
     */
    @PostConstruct
    public void startNettyServer() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(appProperties.getCimServerPort()))
                // keep alive
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childHandler(new CIMServerInitializer());
        ChannelFuture future = bootstrap.bind().sync();
        if (future.isSuccess()) {
            log.info("IM服务启动成功，IM端口是：{}", appProperties.getCimServerPort());
        }
    }

    @PreDestroy
    public void destroy() {
        boss.shutdownGracefully().syncUninterruptibly();
        work.shutdownGracefully().syncUninterruptibly();
        log.info("IM服务优雅停止！");
    }

}
