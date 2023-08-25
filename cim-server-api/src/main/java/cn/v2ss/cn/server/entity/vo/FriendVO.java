package cn.v2ss.cn.server.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 好友详情封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendVO {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户签名
     */
    private String remark;
    /**
     * 用户头像
     */
    private String avatar;
}
