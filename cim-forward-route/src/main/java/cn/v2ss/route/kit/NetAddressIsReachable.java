package cn.v2ss.route.kit;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author: YeFei
 * @Description: 检查ip是否可以到达
 * @Date: 2022-08-05 23:36
 **/
public class NetAddressIsReachable {

    public static Boolean checkAddressReachable(String address, Integer port, Integer timeout) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(address, port), timeout);
            return Boolean.TRUE;
        } catch (IOException exception) {
            return Boolean.FALSE;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                return Boolean.FALSE;
            }
        }
    }
}
