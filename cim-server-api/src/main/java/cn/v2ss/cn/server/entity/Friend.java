package cn.v2ss.cn.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Friend extends BaseEntity {

    private Long id;

    private Long userId;

    private Long friendId;

    private String userRemark;

    private String friendRemark;
}
