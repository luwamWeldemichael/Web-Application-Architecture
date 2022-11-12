package edu.miu.assignment6.aspect;

import edu.miu.assignment6.entity.dto.LogDto;
import edu.miu.assignment6.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    LogService logService;

    @Pointcut("execution( * edu.miu.assignment6.controller.*.*(..))")

    public void logMe() {
    }

    @Around("logMe()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable e) {
            throw e;
        }
        finally {
            saveLog(point, beginTime);
        }

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogDto applicationLog = new LogDto();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        applicationLog.setMethod(request.getMethod());

        applicationLog.setEndPoint(request.getServletPath());
        applicationLog.setPrincipal(SecurityContextHolder.getContext().getAuthentication().getName());
        applicationLog.setRequestTime(Instant.ofEpochMilli(time)
                .atZone(ZoneId.of("America/Chicago")).toLocalDateTime());
        applicationLog.setOperation(className + "." + methodName + "()");
        logService.save(applicationLog);
    }
}
