package com.ebaiyihui.log.dao;

import com.ebaiyihui.log.entity.WxPushApplicationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName WxPushApplicationMapper
 * @description:
 * @author: liyp
 * @create: 2020-08-1014:00
 **/
@Mapper
public interface WxPushApplicationMapper {


    WxPushApplicationEntity selectByClientCode(@Param("clientCode") String clientCode);
}
