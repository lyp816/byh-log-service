package com.ebaiyihui.log.service.impl;

import com.ebaiyihui.log.dao.WxPushApplicationMapper;
import com.ebaiyihui.log.entity.WxPushApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName WxPushApplicationServiceImpl
 * @description:
 * @author: liyp
 * @create: 2020-08-1014:09
 **/
@Service
public class WxPushApplicationServiceImpl {
    @Autowired
    private WxPushApplicationMapper wxPushApplicationMapper;

    public WxPushApplicationEntity selectByClientCode(String clientCode){
        return wxPushApplicationMapper.selectByClientCode(clientCode);
    }
}