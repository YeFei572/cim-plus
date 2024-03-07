package cn.v2ss.cim.route.api.vo.req;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 开始收款的入参
 */
@Data
public class InitIalPaymentReqDTO {

    private Long userId;

    private BigDecimal amount;

}
