package cn.v2ss.route.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.v2ss.cim.route.api.vo.res.CIMServerResVO;
import cn.v2ss.cn.server.entity.User;
import cn.v2ss.common.constant.Constants;
import cn.v2ss.common.entity.RouteInfo;
import cn.v2ss.common.entity.req.LoginReq;
import cn.v2ss.common.entity.res.UserInfoRes;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.kit.RedisUtils;
import cn.v2ss.common.route.algorithm.RouteHandle;
import cn.v2ss.common.util.RouteInfoUtils;
import cn.v2ss.route.kit.ZooKit;
import cn.v2ss.route.mapper.UserMapper;
import cn.v2ss.route.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static cn.v2ss.route.constant.Constant.ROUTE_PREFIX;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final ZooKit zooKit;

    private final RouteHandle routeHandle;

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
        // 如果登陆成功，就保存用户信息到缓存中去
        List<String> allNodes = zooKit.getAllNodes();
        String server = routeHandle.routeServer(allNodes, String.valueOf(exist.getId()));
        log.info("当前登录用户为：{}, 路由服务器为：{}", exist.getNickname(), server);
        RouteInfo routeInfo = RouteInfoUtils.parse(server);
        zooKit.checkServerAvailable(routeInfo);
        // 保存路由信息
        RedisUtils.setCacheObject(ROUTE_PREFIX + exist.getId(), server);
        result.setRouteInfo(routeInfo);
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
