package cn.v2ss.route.service;

import cn.v2ss.cn.server.entity.Friend;
import cn.v2ss.cn.server.entity.vo.FriendVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface FriendService extends IService<Friend> {

    /**
     * 获取我的好友信息
     *
     * @return 好友列表
     */
    List<FriendVO> getMyFriends();
}
