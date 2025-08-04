package com.eddiAnton.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogger {
    private static final Logger log = LoggerFactory.getLogger(ControllerLogger.class);

    @Before("execution(* com.eddiAnton.controller.*.*(..))")
    public void logRequest (JoinPoint joinPoint) {
        log.info("Выполняется запрос к {} с аргументами: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.eddiAnton.controller.*.*(..))", returning = "result")
    public void logResponse (JoinPoint joinPoint, Object result) {
        log.info("Ответ от {}: {}", joinPoint.getSignature(), result);
    }
}
