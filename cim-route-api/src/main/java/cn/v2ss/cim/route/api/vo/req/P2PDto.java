package cn.v2ss.cim.route.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: YeFei
 * @Description: 单聊请求入参
 * @Date: 2022-08-05 22:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class P2PDto {

    private Long userId;

    private Long receiveUserId;

    private String msg;
}
