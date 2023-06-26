package cn.v2ss.route.service.impl;

import cn.v2ss.cn.server.entity.User;
import cn.v2ss.common.entity.CIMUserInfo;
import cn.v2ss.common.kit.RedisUtils;
import cn.v2ss.route.mapper.UserMapper;
import cn.v2ss.route.service.UserInfoCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static cn.v2ss.route.constant.Constant.ACCOUNT_PREFIX;

@Service
@RequiredArgsConstructor
public class UserInfoCacheServiceImpl implements UserInfoCacheService {

    private final UserMapper userMapper;

    @Override
    public CIMUserInfo loadUserInfoByUserId(Long userId) {
        // 优先从缓存中获取用户数据，如果缓存中没有数据再从数据库中获取
        CIMUserInfo cimUserInfo = RedisUtils.getCacheObject(ACCOUNT_PREFIX);
        if (null == cimUserInfo) {
            User user = userMapper.selectById(userId);
        }
        return null;
    }
}
