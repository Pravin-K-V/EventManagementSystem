package com.spring.EventManagementSystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger((ServiceLoggingAspect.class));

    @Before("execution(* com.spring.EventManagementSystem.service..*(..))")
    public void logBefore(JoinPoint joinPoint){
        logger.info("Entering the method {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning("execution(* com.spring.EventManagementSystem.service..*(..))")
    public void logAfterReturning(JoinPoint joinPoint){
        logger.info("Exiting the method {} successfully", joinPoint.getSignature().toShortString());
    }

    @AfterThrowing("execution(* com.spring.EventManagementSystem.service..*(..))")
    public void logAfterThrowing(JoinPoint joinPoint){
        logger.info("Exiting the method {} with error", joinPoint.getSignature().toShortString());
    }
}
