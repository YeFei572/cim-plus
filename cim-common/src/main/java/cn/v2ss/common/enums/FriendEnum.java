package cn.v2ss.common.enums;

import lombok.Getter;

public class FriendEnum {

    /**
     * 好友请求/加群请求枚举
     */
    public enum FriendshipRequestEnum {
        PERSON(1, "个人"),
        GROUP(2, "群组");

        @Getter
        private final int code;
        @Getter
        private final String msg;

        FriendshipRequestEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }
}
