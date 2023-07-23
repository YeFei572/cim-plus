package cn.v2ss.cn.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 好友请求
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FriendshipRequest extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long groupId;

    private Long requestUserId;

    private String remark;

    /**
     * 类型 {@link cn.v2ss.common.enums.FriendEnum.FriendshipRequestEnum}
     */
    private Integer type = 0;

}
