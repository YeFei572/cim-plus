package cn.v2ss.cn.server;

import cn.v2ss.common.entity.req.ChatDto;

public interface ServerApi {

    /**
     * 发送消息给服务端
     *
     * @param dto 参数
     * @return 结果
     * @throws Exception 发送异常
     */
    Object sendSmg(ChatDto dto) throws Exception;
}
