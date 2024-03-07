package cn.v2ss.cim.route.api.vo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class GameGroupRequestDTO {

    /**
     * 底赔
     */
    @NotNull(message = "你要告诉我你玩多少钱1盘")
    private BigDecimal bottomClaim;
}
