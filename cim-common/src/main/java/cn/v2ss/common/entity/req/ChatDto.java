package cn.v2ss.common.entity.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: YeFei
 * @Description: 编解码发送
 * @Date: 2022-08-05 22:46
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto extends BaseRequest {


    /**
     * 消息发送人的id
     */
    private Long fromUserId;

    /**
     * 消息接收对象的id，可能是用户id，也可能是群id
     */
    private Long targetId;

    /**
     * 聊天的类型，1个人，2群组{@link cn.v2ss.common.enums.FriendEnum.FriendshipRequestEnum}
     */
    private Integer chatType;
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 消息类型 {@link cn.v2ss.common.enums.MsgTypeEnum}
     *     LOGIN(1, "登录"),
     *     TXT(2, "文本"),
     *     PIC(3, "图片"),
     *     FILE(4, "文件"),
     *     VOICE(5, "音频"),
     *     VIDEO(6, "视频"),
     */
    private Integer msgType;
}
