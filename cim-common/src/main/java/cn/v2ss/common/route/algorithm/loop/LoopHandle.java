package cn.v2ss.common.route.algorithm.loop;

import cn.v2ss.common.enums.StatusEnum;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.route.algorithm.RouteHandle;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: YeFei
 * @Description: 循环模式
 * @Date: 2022-06-22 21:38
 **/
public class LoopHandle implements RouteHandle {
    private AtomicLong index = new AtomicLong();

    @Override
    public String routeServer(List<String> values, String key) {
        if (values.isEmpty()) {
            throw new CIMException(StatusEnum.SERVER_NOT_AVAILABLE);
        }
        long position = index.incrementAndGet() % values.size();
        position = position < 0 ? 0L : position;
        return values.get(Math.toIntExact(position));
    }
}
