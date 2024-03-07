package cn.v2ss.route.service.impl;

import cn.v2ss.cn.server.entity.GameRecord;
import cn.v2ss.route.mapper.GameRecordMapper;
import cn.v2ss.route.service.GameRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GameRecordServiceImpl extends ServiceImpl<GameRecordMapper, GameRecord> implements GameRecordService {
}
