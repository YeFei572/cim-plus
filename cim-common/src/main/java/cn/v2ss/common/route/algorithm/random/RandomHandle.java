package cn.v2ss.common.route.algorithm.random;

import cn.v2ss.common.enums.StatusEnum;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.route.algorithm.RouteHandle;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-22 21:30
 **/
public class RandomHandle implements RouteHandle {
    @Override
    public String routeServer(List<String> values, String key) {

        int size = values.size();
        if (size == 0) {
            throw new CIMException(StatusEnum.SERVER_NOT_AVAILABLE);
        }
        // 随机获取一个机器进行返回
        int offset = ThreadLocalRandom.current().nextInt(size);
        return values.get(offset);
    }
}
