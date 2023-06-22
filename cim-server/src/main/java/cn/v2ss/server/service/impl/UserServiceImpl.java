package cn.v2ss.server.service.impl;

import cn.v2ss.cn.server.entity.User;
import cn.v2ss.server.mapper.UserMapper;
import cn.v2ss.server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
