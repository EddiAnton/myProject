package com.eddiAnton.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.eddiAnton.service.*.*(..))")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        logger.info("Выполняется метод {} класса {}", methodName, className);

        try {
            Object result = joinPoint.proceed();
            logger.info("Метод {} выполнен успешно", methodName);
            return result;
        } catch (Exception e) {
            logger.error("Ошибка в методе {}: {}", methodName, e.getMessage());
            throw e;
        }
    }

    @Around("execution(* com.eddiAnton.model.*.*(..))")
    public Object logModelMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.debug("Вызван метод из Модели {}", methodName);
        return joinPoint.proceed();
    }
}
