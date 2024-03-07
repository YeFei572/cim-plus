package cn.v2ss.route.service;

import cn.v2ss.cim.route.api.vo.req.GameGroupRequestDTO;
import cn.v2ss.cim.route.api.vo.req.InitIalPaymentReqDTO;
import cn.v2ss.cn.server.entity.GameGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface GameGroupService extends IService<GameGroup> {
    /**
     * 创建新的局
     *
     * @param req 创建条件
     * @return 是否成功
     */
    boolean createNewGroup(GameGroupRequestDTO req);

    /**
     * 加入新局
     *
     * @param groupId 新局id
     * @return 是否成功
     */
    Boolean joinGroup(Long groupId);

    /**
     * 更改局的状态
     *
     * @param groupId 局id
     * @return 是否成功
     */
    Boolean changeGroupStatus(Long groupId);

    /**
     * 发起支付功能
     *
     * @param params 发起参数
     * @return 是否成功
     */
    Boolean initialPayment(List<InitIalPaymentReqDTO> params);
}
