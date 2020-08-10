package com.ebaiyihui.log.service.impl;

import com.alibaba.fastjson.JSON;
import com.ebaiyihui.log.entity.Log;
import com.ebaiyihui.log.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LogService
 * @description: 记录操作日志
 * @author: liyp
 * @create: 2020-08-0711:54
 **/
@Service
@Slf4j
public class LogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(String userViewId, String browser, String ip, ProceedingJoinPoint joinPoint, Log adminLog) {
        log.info("进入纪录日志service");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.ebaiyihui.log.annotation.Log aopLog = method.getAnnotation(com.ebaiyihui.log.annotation.Log.class);

        Integer logActionType = aopLog.type().getValue();

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";

        StringBuilder params = new StringBuilder("{");
        //参数值
        List<Object> argValues = new ArrayList<>(Arrays.asList(joinPoint.getArgs()));
        //参数名称
        for (Object argValue : argValues) {
            params.append(argValue).append(" ");
        }
        // 描述
        if (adminLog != null) {
            adminLog.setDescription(aopLog.value());
        }
        assert log != null;
        adminLog.setRequestIp(ip);

        //String loginPath = "login";
        adminLog.setAddress(StringUtil.getCityInfo(adminLog.getRequestIp()));
        adminLog.setMethod(methodName);
        adminLog.setUserViewId(userViewId);
        adminLog.setParams(params.toString() + " }");
        adminLog.setBrowser(browser);
        adminLog.setLogActionType(logActionType);
        log.info("参数组装ok，准存mongo------>{}", JSON.toJSONString(adminLog));
        mongoTemplate.save(adminLog);

    }

}