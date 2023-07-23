package cn.v2ss.route.service;

import cn.v2ss.cim.route.api.vo.req.FriendshipRequestDTO;
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

    /**
     * 根据手机号查询陌生人信息
     *
     * @param phone 手机号
     * @return 陌生人信息
     */
    FriendVO queryNewFriend(String phone);

    /**
     * 发起好友/加群请求
     *
     * @param dto 参数封装类
     * @return 是否发起成功
     */
    Boolean addNewFriend(FriendshipRequestDTO dto);
}
