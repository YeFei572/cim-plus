package cn.v2ss.route.service.impl;

import cn.v2ss.cn.server.entity.TransactionRecord;
import cn.v2ss.route.mapper.TransactionRecordMapper;
import cn.v2ss.route.service.TransactionRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TransactionRecordServiceImpl extends ServiceImpl<TransactionRecordMapper, TransactionRecord> implements TransactionRecordService {
}
