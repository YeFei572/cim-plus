package cn.v2ss.common.enums;

import lombok.Getter;

public class UserEnum {

    public enum userState {
        NORMAL(0, "正常"),
        DISABLE(1, "禁止使用"),
        ;
        @Getter
        private final Integer code;
        @Getter
        private final String msg;

        userState(Integer code, String msg) {
            this.code = code;

            this.msg = msg;
        }
    }
}
