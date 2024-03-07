package cn.v2ss.route.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.v2ss.cim.route.api.vo.req.GameGroupRequestDTO;
import cn.v2ss.cim.route.api.vo.req.InitIalPaymentReqDTO;
import cn.v2ss.cn.server.entity.GameGroup;
import cn.v2ss.common.enums.GameEnum;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.route.mapper.GameGroupMapper;
import cn.v2ss.route.service.GameGroupService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Wrapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameGroupServiceImpl extends ServiceImpl<GameGroupMapper, GameGroup> implements GameGroupService {
    /**
     * 创建新的群组
     */
    @Override
    public boolean createNewGroup(GameGroupRequestDTO req) {
        Long currentUserId = StpUtil.getLoginIdAsLong();
        // 如果用户重复创建局
        GameGroup existGroup = this.getOne(Wrappers.<GameGroup>lambdaQuery()
                .eq(GameGroup::getFirstId, currentUserId)
                .ne(GameGroup::getStatus, GameEnum.gameGroupStatus.finished.getCode()), false);
        if (Objects.nonNull(existGroup)) {
            throw new CIMException("当前用户以存在未结算的局");
        }
        // 先组局
        GameGroup gameGroup = new GameGroup();
        gameGroup.setBottomClaim(req.getBottomClaim());
        gameGroup.setFirstId(currentUserId);
        gameGroup.setStatus(GameEnum.gameGroupStatus.waiting.getCode());
        gameGroup.setCreateTime(DateUtil.date().getTime());
        gameGroup.setUpdateTime(gameGroup.getCreateTime());
        this.save(gameGroup);
        return Boolean.TRUE;
    }

    @Override
    public Boolean joinGroup(Long groupId) {
        long currentLoginId = StpUtil.getLoginIdAsLong();
        // 查询对应的局
        GameGroup existGroup = this.getById(groupId);
        if (null == existGroup || Objects.equals(existGroup.getStatus(), GameEnum.gameGroupStatus.waiting.getCode())) {
            throw new CIMException("当前局儿不存在或者已经开始了！");
        }
        if (Objects.isNull(existGroup.getSecondId())) {
            existGroup.setSecondId(currentLoginId);
            existGroup.setSecondAssets(BigDecimal.ZERO);
        } else if (Objects.isNull(existGroup.getThirdId())) {
            existGroup.setThirdId(currentLoginId);
            existGroup.setThirdAssets(BigDecimal.ZERO);
        } else if (Objects.isNull(existGroup.getFourthId())) {
            existGroup.setFourthId(currentLoginId);
            existGroup.setFourthAssets(BigDecimal.ZERO);
        } else {
            throw new CIMException("当前局儿已经没有多的空位了！");
        }
        this.updateById(existGroup);
        return Boolean.TRUE;
    }

    @Override
    public Boolean changeGroupStatus(Long groupId) {
        long currentLoginId = StpUtil.getLoginIdAsLong();
        // 查询对应的局
        GameGroup existGroup = this.getById(groupId);
        if (null == existGroup || !Objects.equals(existGroup.getStatus(), GameEnum.gameGroupStatus.waiting.getCode())) {
            throw new CIMException("当前局儿不存在或者已经开始了！");
        }
        if (!Objects.equals(currentLoginId, existGroup.getFirstId())) {
            throw new CIMException("当前用户无权更改状态！");
        }
        if (existGroup.getThirdId() == null) {
            throw new CIMException("人数不足，无法开始!");
        }
        existGroup.setStatus(GameEnum.gameGroupStatus.working.getCode());
        this.updateById(existGroup);
        return Boolean.TRUE;
    }

    @Override
    public Boolean initialPayment(List<InitIalPaymentReqDTO> params) {
        if (params.isEmpty() || params.size() > 3) {
            throw new CIMException("收款人数不对，检查一下吧！");
        }
        return null;
    }
}
