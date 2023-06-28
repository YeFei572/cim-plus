package cn.v2ss.cim.route.api.vo.req;

import cn.v2ss.common.entity.req.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: YeFei
 * @Description: 编解码发送
 * @Date: 2022-08-05 22:46
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto extends BaseRequest {

    private Long userId;

    private String msg;

}
