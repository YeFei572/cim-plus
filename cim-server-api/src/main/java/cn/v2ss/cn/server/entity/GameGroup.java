package cn.v2ss.cn.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class GameGroup extends BaseEntity{

    private Long id;

    // 1号位用户id
    private Long firstId;

    // 2号位用户id
    private Long secondId;

    // 3号伟用户id
    private Long thirdId;

    // 四号位用户id
    private Long fourthId;

    // 1号位资产
    private BigDecimal firstAssets;

    private BigDecimal secondAssets;

    private BigDecimal thirdAssets;

    private BigDecimal fourthAssets;

    /**
     * 1准备中， 2进行中， 3完结中
     * {@link cn.v2ss.common.enums.GameEnum.gameGroupStatus}
     */
    private int status;

    // 底赔，屁糊额度
    private BigDecimal bottomClaim;

}
