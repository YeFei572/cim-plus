package cn.v2ss.route.controller;

import cn.v2ss.cim.route.api.vo.req.GameGroupRequestDTO;
import cn.v2ss.cim.route.api.vo.req.InitIalPaymentReqDTO;
import cn.v2ss.cn.server.entity.BaseEntity;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.kit.ResultUtils;
import cn.v2ss.route.service.GameGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 积分功能控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/pass")
public class PassController {

    private final GameGroupService gameGroupService;

    /**
     * 发起新局
     *
     * @param req 发起参数
     * @return 是否成功
     */
    @PostMapping("/createNewTable")
    public BaseResponse<Boolean> createNewTable(@Valid @RequestBody GameGroupRequestDTO req) {
        return ResultUtils.ok(gameGroupService.createNewGroup(req));
    }

    /**
     * 加入指定的局中去
     *
     * @param groupId 局id
     * @return 是否成功
     */
    @PostMapping("/joinGroup/{groupId}")
    public BaseResponse<Boolean> joinGroup(@PathVariable("groupId") Long groupId) {
        return ResultUtils.ok(gameGroupService.joinGroup(groupId));
    }

    /**
     * 开始本局游戏
     *
     * @param groupId 局id
     * @return 是否成功
     */
    @PostMapping("/groupStatus/{groupId}")
    public BaseResponse<Boolean> changeGroupStatus(@PathVariable("groupId") Long groupId) {
        return ResultUtils.ok(gameGroupService.changeGroupStatus(groupId));
    }

    @PostMapping("/initialPayment")
    public BaseResponse<Boolean> initialPayment(@RequestBody List<InitIalPaymentReqDTO> params) {
        return ResultUtils.ok(gameGroupService.initialPayment(params));
    }
}
