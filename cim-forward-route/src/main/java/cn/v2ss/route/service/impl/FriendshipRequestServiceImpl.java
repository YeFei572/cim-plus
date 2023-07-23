package cn.v2ss.route.service.impl;

import cn.v2ss.cn.server.entity.FriendshipRequest;
import cn.v2ss.route.mapper.FriendshipRequestMapper;
import cn.v2ss.route.service.FriendshipRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendshipRequestServiceImpl extends ServiceImpl<FriendshipRequestMapper, FriendshipRequest> implements FriendshipRequestService {
}
