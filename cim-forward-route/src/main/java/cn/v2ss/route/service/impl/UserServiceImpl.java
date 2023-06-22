package cn.v2ss.route.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.v2ss.cn.server.entity.User;
import cn.v2ss.common.constant.Constants;
import cn.v2ss.common.entity.req.LoginReq;
import cn.v2ss.common.entity.res.UserInfoRes;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.route.mapper.UserMapper;
import cn.v2ss.route.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserInfoRes login(LoginReq req) {
        User exist = this.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getPhone, req.getPhone()).last(Constants.LIMIT_ONE));
        Optional.ofNullable(exist).orElseThrow(() -> new CIMException("用户不存在"));
        // TODO 密码没有加密，BCrypt加密方式，用SaToken带的工具类
        if (!exist.getPassword().equals(req.getPassword())) {
            throw new CIMException("密码错误！");
        }
        StpUtil.login(exist.getId());
        String token = StpUtil.getTokenValue();
        UserInfoRes result = new UserInfoRes();
        BeanUtil.copyProperties(exist, result);
        result.setToken(token);
        return result;
    }

    @Override
    public Boolean register(LoginReq req) {
        // 检查用户是否存在
        User exist = this.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getPhone, req.getPhone()).last(Constants.LIMIT_ONE));
        if (null != exist) {
            throw new CIMException("账户已存在，请勿重复注册！");
        }
        User user = new User();
        user.setGender(1);
        user.setNickname("");
        user.setPhone(req.getPhone());
        user.setPassword(req.getPassword());
        user.setCreateTime(DateUtil.date().getTime());
        user.setUpdateTime(user.getCreateTime());
        this.save(user);
        return Boolean.TRUE;
    }
}
