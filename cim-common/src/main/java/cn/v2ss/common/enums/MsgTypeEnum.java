package cn.v2ss.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MsgTypeEnum {

    LOGIN(1, "登录"),
    TXT(2, "文本"),
    PIC(3, "图片"),
    FILE(4, "文件"),
    VOICE(5, "音频"),
    VIDEO(6, "视频"),
    ;

    /**
     * 枚举值码
     */
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String message;

}
