package cn.v2ss.common.constant;

public class Constants {

    /**
     * 服务端手动 push 次数
     */
    public static final String COUNTER_SERVER_PUSH_COUNT = "counter.server.push.count" ;


    /**
     * 客户端手动 push 次数
     */
    public static final String COUNTER_CLIENT_PUSH_COUNT = "counter.client.push.count" ;


    /**
     * 自定义报文类型
     */
    public static class CommandType{
        /**
         * 登录
         */
        public static final int LOGIN = 1 ;
        /**
         * 业务消息
         */
        public static final int MSG = 2 ;

        /**
         * ping
         */
        public static final int PING = 3 ;
    }

    public static final String LIMIT_ONE = "LIMIT 1";
    public static final String HTTP = "http://";
    public static final String COLON = ":";

    public static final String USER_TOKEN_KEY = "cim-plus:login:token:";
}
