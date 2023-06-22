package cn.v2ss.route.service;

import cn.v2ss.cn.server.entity.User;
import cn.v2ss.common.entity.req.LoginReq;
import cn.v2ss.common.entity.res.UserInfoRes;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    /**
     * 用户登录接口
     *
     * @param req 登陆参数
     * @return 用户信息
     */
    UserInfoRes login(LoginReq req);

    /**
     * 注册
     *
     * @param req 注册参数
     * @return 是否成功
     */
    Boolean register(LoginReq req);
}
