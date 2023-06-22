package cn.v2ss.cn.client.client;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-10-02 17:19
 **/
@Slf4j
@Component
public class CIMClient {

    private EventLoopGroup group = new NioEventLoopGroup(0, new DefaultThreadFactory("cim-work"));


    @PostConstruct
    public void start() {

    }

}
