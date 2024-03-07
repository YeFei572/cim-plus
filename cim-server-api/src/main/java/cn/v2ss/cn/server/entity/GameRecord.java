package cn.v2ss.cn.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class GameRecord extends BaseEntity {

    private Long id;

    private Long groupId;

    // 局名
    private String roundName;

    /**
     * 状态
     * {@link cn.v2ss.common.enums.GameEnum.gameGroupStatus}
     */
    private int status;

    // 胜利人的id, 多个人以逗号隔开
    private String winUserIds;

    // 失败方的id， 多个人以逗号隔开
    private String failedUserIds;

    /**
     * 1号用户本局资产变化
     */
    private BigDecimal firstAccount;

    /**
     * 2号用户本局资产变化
     */
    private BigDecimal secondAccount;

    /**
     * 3号用户本局资产变化
     */
    private BigDecimal thirdAccount;

    /**
     * 4号用户本局资产变化
     */
    private BigDecimal fourthAccount;

}
