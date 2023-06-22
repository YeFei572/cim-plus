package cn.v2ss.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: YeFei
 * @Description: 用户信息
 * @Date: 2022-08-05 23:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CIMUserInfo {

    private Long userId;

    private String username;
}
