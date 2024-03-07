package cn.v2ss.common.enums;

import lombok.Getter;

/**
 * 游戏相关
 */
public class GameEnum {

    @Getter
    public enum gameGroupStatus {
        waiting(1, "等待中"),
        working(2, "进行中"),
        finished(3, "完成"),
        ;
        private final int code;

        private final String desc;

        gameGroupStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    @Getter

    public enum transactionType {
        pihu(1, "屁糊"),
        zhonghu(2, "中糊"),
        dahu(3, "大糊"),
        gang(4, "杠"),
        hei(5, "黑"),
        fail(6, "流局");


        private final int code;

        private final String desc;

        transactionType(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }
}
