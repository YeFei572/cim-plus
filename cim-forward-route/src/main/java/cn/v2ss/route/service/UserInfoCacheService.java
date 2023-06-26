package cn.v2ss.route.service;

import cn.v2ss.common.entity.CIMUserInfo;

public interface UserInfoCacheService {

    /**
     * 根据用户id去加载用户信息到缓存中去
     *
     * @param userId 用户id
     * @return 用户信息封装类
     */
    CIMUserInfo loadUserInfoByUserId(Long userId);
}
