package cn.v2ss.cn.server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionRecord extends BaseEntity {

    private Long id;

    private Long recordId;

    private Long userId;

    private Long targetId;

    private BigDecimal money;

    /**
     * 流水类型
     * {@link cn.v2ss.common.enums.GameEnum.transactionType}
     */
    private int type;
}
