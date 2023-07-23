package cn.v2ss.cim.route.api.vo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FriendshipRequestDTO {

    @NotNull(message = "用户id不能为空")
    private Long userId;

    private String remark;
}
