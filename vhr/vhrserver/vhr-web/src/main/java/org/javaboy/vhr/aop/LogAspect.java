package org.javaboy.vhr.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.OpLog;
import org.javaboy.vhr.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Autowired
    OpLogService opLogService;

    @Pointcut("execution(* org..controller..*.*(..)) " +
            "&& !execution(* org.javaboy.vhr.controller.LoginController.*(..))")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //有登陆用户就返回登录用户，没有就返回null
        OpLog log =new OpLog();
        log.setAdddate(new Date());
        String methodName = joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName();
        log.setOperate(methodName);
        log.setHrid(0);
        if (authentication != null) {

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                Hr hr = (Hr) authentication.getPrincipal();
                if (hr.getId() != null){
                    log.setHrid(hr.getId());
                }
            }
        }
        opLogService.add(log);
        return joinPoint.proceed();
    }
}
