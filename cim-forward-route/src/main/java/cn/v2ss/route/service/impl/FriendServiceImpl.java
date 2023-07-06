package cn.v2ss.route.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.v2ss.cn.server.entity.Friend;
import cn.v2ss.cn.server.entity.User;
import cn.v2ss.cn.server.entity.vo.FriendVO;
import cn.v2ss.route.mapper.FriendMapper;
import cn.v2ss.route.service.FriendService;
import cn.v2ss.route.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

    private final UserService userService;

    @Override
    public List<FriendVO> getMyFriends() {
        long currentUserId = StpUtil.getLoginIdAsLong();
        List<Friend> friendList = this.list(Wrappers.<Friend>lambdaQuery().eq(Friend::getUserId, currentUserId).or().eq(Friend::getFriendId, currentUserId));
        if (friendList.isEmpty()) {
            return Collections.emptyList();
        }
        // 我加别人的
        Map<Long, Friend> mineMap = friendList.stream().filter(i -> i.getUserId().equals(currentUserId))
                .collect(Collectors.toMap(Friend::getFriendId, i -> i));
        // 别人加我的
        Map<Long, Friend> otherMap = friendList.stream().filter(i -> i.getFriendId().equals(currentUserId))
                .collect(Collectors.toMap(Friend::getUserId, i -> i));
        Set<Long> friendIds = mineMap.keySet();
        friendIds.addAll(otherMap.keySet());
        List<User> users = userService.listByIds(friendIds);
        List<FriendVO> result = new ArrayList<>();
        users.forEach(item -> {
            // 处理备注信息
            String remark;
            if (mineMap.containsKey(item.getId())) {
                remark = mineMap.get(item.getId()).getUserRemark();
            } else {
                remark = otherMap.get(item.getId()).getFriendRemark();
            }
            FriendVO vo = new FriendVO(item.getId(), item.getNickname(), remark, item.getAvatar());
            result.add(vo);
        });
        return result;
    }
}
