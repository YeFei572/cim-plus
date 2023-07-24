package cn.v2ss.route.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.v2ss.cim.route.api.vo.req.FriendshipRequestDTO;
import cn.v2ss.cn.server.entity.Friend;
import cn.v2ss.cn.server.entity.FriendshipRequest;
import cn.v2ss.cn.server.entity.User;
import cn.v2ss.cn.server.entity.vo.FriendVO;
import cn.v2ss.common.constant.Constants;
import cn.v2ss.common.enums.FriendEnum;
import cn.v2ss.common.enums.UserEnum;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.route.mapper.FriendMapper;
import cn.v2ss.route.service.FriendService;
import cn.v2ss.route.service.FriendshipRequestService;
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

    private final FriendshipRequestService friendshipRequestService;

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

    @Override
    public FriendVO queryNewFriend(String phone) {
        User exist = userService.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getPhone, phone)
                .eq(User::getState, UserEnum.userState.NORMAL.getCode())
                .last(Constants.LIMIT_ONE));
        Optional.ofNullable(exist).orElseThrow(() -> new CIMException("该用户不存在或者状态异常！"));
        FriendVO result = BeanUtil.copyProperties(exist, FriendVO.class);
        result.setUserId(exist.getId());
        return result;
    }

    /**
     * 发起好友/加群请求
     *
     * @param dto 参数封装类
     * @return 是否发起成功
     */
    @Override
    public Boolean addNewFriend(FriendshipRequestDTO dto) {
        Long currentUserId = StpUtil.getLoginIdAsLong();
        if (dto.getUserId().equals(currentUserId)) {
            throw new CIMException("不能添加自己为好友！");
        }
        // 如果已经是好友也不允许添加
        Friend existFriend = this.getOne(Wrappers.<Friend>lambdaQuery().select(Friend::getId)
                .eq(Friend::getUserId, currentUserId).eq(Friend::getFriendId, dto.getUserId())
                .or(w -> w.eq(Friend::getFriendId, currentUserId).eq(Friend::getUserId, dto.getUserId())), Boolean.TRUE);
        if (Objects.nonNull(existFriend)) {
            throw new CIMException("已经是好友了，不能重复添加！");
        }
        // 检查目标用户的信息是否存在且正常
        User exist = userService.getById(dto.getUserId());
        Optional.ofNullable(exist).orElseThrow(() -> new CIMException("该用户不存在！"));
        if (!UserEnum.userState.NORMAL.getCode().equals(exist.getState())) {
            throw new CIMException("用户状态异常！");
        }
        FriendshipRequest request = new FriendshipRequest();
        request.setRequestUserId(StpUtil.getLoginIdAsLong());
        request.setType(FriendEnum.FriendshipRequestEnum.PERSON.getCode());
        request.setUserId(dto.getUserId());
        request.setRemark(dto.getRemark());
        request.setCreateTime(DateUtil.currentSeconds());
        request.setUpdateTime(request.getCreateTime());
        friendshipRequestService.save(request);
        return Boolean.TRUE;
    }
}
