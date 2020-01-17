package com.service.bridge.service.user;

import com.common.core.annotation.OperationSub;
import com.service.bridge.config.ServicePathConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author 袁毅雄
 * @description 用户认证远程服务定义接口
 * @date 2019/8/22
 */
@RequestMapping(ServicePathConstant.PATH_V1 + "/user/auth")
public interface UserAuthRemoteService {

    /**
     * 获取真实姓名
     *
     * @param userIds
     * @return
     */
    @OperationSub(operationMaxNum = 200)
    @PostMapping("/getUserRealName")
    Map<Long, String> getRealNameByUserIds(@RequestBody List<Long> userIds);

}
