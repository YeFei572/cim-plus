package cn.v2ss.route.controller;

import cn.v2ss.cim.route.api.vo.req.FriendshipRequestDTO;
import cn.v2ss.cn.server.entity.vo.FriendVO;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.kit.ResultUtils;
import cn.v2ss.route.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendService friendService;

    /**
     * 获取我的好友列表
     *
     * @return 好友列表
     */
    @GetMapping("/getMyFriends")
    public BaseResponse<List<FriendVO>> getMyFriends() {
        return ResultUtils.ok(friendService.getMyFriends());
    }

    /**
     * 通过手机号查询一个陌生人信息
     *
     * @return 陌生人信息
     */
    @GetMapping("/queryNewFriend/{phone}")
    public BaseResponse<FriendVO> queryNewFriend(@PathVariable("phone") String phone) {
        return ResultUtils.ok(friendService.queryNewFriend(phone));
    }

    /**
     * 发起好友/加群请求
     *
     * @param dto 参数封装类
     * @return 是否发起成功
     */
    @PostMapping("/addNewFriend")
    public BaseResponse<Boolean> addNewFriend(@Valid @RequestBody FriendshipRequestDTO dto) {
        return ResultUtils.ok(friendService.addNewFriend(dto));
    }
}
