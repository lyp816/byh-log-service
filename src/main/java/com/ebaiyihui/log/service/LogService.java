package com.ebaiyihui.log.service;

import com.ebaiyihui.log.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author:hanxin
 * @Date:2020/8/25 18:47
 * @Description
 */
public interface LogService {
    void save(String userViewId, String browser, String ip, ProceedingJoinPoint joinPoint, Log adminLog);
}
