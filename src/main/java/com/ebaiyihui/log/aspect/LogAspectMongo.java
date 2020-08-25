package com.ebaiyihui.log.aspect;

import com.ebaiyihui.log.entity.Log;
import com.ebaiyihui.log.service.impl.LogServiceImpl;
import com.ebaiyihui.log.util.IpAddressUtil;
import com.ebaiyihui.log.util.RequestHolder;
import com.ebaiyihui.log.util.StringUtil;
import com.ebaiyihui.log.util.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lyp
 */

@Component
@Aspect
@Slf4j
public class LogAspectMongo {
    private final LogServiceImpl logService;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    public LogAspectMongo(LogServiceImpl logService) {
        this.logService = logService;
    }

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.ebaiyihui.log.annotation.Log)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        Log log = new Log("INFO",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        String userViewId=request.getHeader("userId");
        logService.save(userViewId, StringUtil.getBrowser(request), IpAddressUtil.getIpAddr(request),joinPoint, log);
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("========错误信息======>{}", ThrowableUtil.getStackTrace(e));
        Log log = new Log("ERROR",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        log.setExceptionDetail(ThrowableUtil.getStackTrace(e).getBytes());
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        String userViewId=request.getHeader("userId");
        logService.save(userViewId, StringUtil.getBrowser(request), IpAddressUtil.getIpAddr(request), (ProceedingJoinPoint)joinPoint, log);
    }

}
