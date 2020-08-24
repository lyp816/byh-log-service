package com.ebaiyihui.log.controller;

import com.ebaiyihui.log.annotation.Log;
import com.ebaiyihui.log.entity.WxPushApplicationEntity;
import com.ebaiyihui.log.enums.LogActionType;
import com.ebaiyihui.log.service.impl.WxPushApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TestController
 * @description: 测试控制层
 * @author: liyp
 * @create: 2020-08-0717:28
 **/
@RestController
@RequestMapping("/TestController")
public class TestController {
    @Autowired
    private WxPushApplicationServiceImpl wxPushApplicationService;

    @GetMapping("/getByClientCode")
    @Log(value = "会诊模块",enable = true,type = LogActionType.UPDATE)
    public WxPushApplicationEntity getByClientCode(@RequestParam("clientCode") String clientCode){
        return wxPushApplicationService.selectByClientCode(clientCode);
    }
}