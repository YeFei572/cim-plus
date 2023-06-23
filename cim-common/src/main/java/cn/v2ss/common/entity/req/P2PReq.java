package cn.v2ss.common.entity.req;

import lombok.Data;

@Data
public class P2PReq {
    // 接收人用户id
    private Long receiveUserId;
    // 消息内容
    private String msg;
    // 消息类型
    private Integer type;
}
