package cn.v2ss.cn.server.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendVO {

    private Long userId;

    private String nickname;

    private String remark;

    private String avatar;
}
