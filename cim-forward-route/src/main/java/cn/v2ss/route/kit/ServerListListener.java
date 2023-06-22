package cn.v2ss.route.kit;

import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-06-22 22:08
 **/
@Slf4j
public class ServerListListener implements Runnable {

//    private AppConfiguration appConfiguration;

    @Autowired
    private ZooKit zooKit;

    public ServerListListener() {
        zooKit = SpringUtil.getBean(ZooKit.class);
//        appConfiguration = SpringUtil.getBean(AppConfiguration.class);
    }

    @Override
    public void run() {
        // 注册监听服务
        zooKit.subscribeEvent();
    }

}
