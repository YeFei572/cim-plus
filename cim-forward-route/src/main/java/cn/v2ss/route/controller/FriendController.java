package cn.v2ss.route.controller;

import cn.v2ss.cn.server.entity.vo.FriendVO;
import cn.v2ss.common.entity.res.BaseResponse;
import cn.v2ss.common.kit.ResultUtils;
import cn.v2ss.route.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/getMyFriends")
    public BaseResponse<List<FriendVO>> getMyFriends() {
        return ResultUtils.ok(friendService.getMyFriends());
    }
}
