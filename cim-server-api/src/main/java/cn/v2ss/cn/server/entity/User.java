package cn.v2ss.cn.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String phone;

    private String password;

    private String nickname;

    private String avatar;

    private Integer gender;

    private String remark;

    /**
     * 用户状态
     * {@link cn.v2ss.common.enums.UserEnum.userState}
     */
    private Integer state;

    private Long createTime;

    private Long updateTime;

}
