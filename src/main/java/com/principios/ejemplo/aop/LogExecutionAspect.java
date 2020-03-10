package com.principios.ejemplo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//point-cut: com.principios.ejemplo.annotations.LogExecutionTime
    @Around("@annotation(com.principios.ejemplo.annotations.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //Advice
    	final long start = System.currentTimeMillis();
    	//join-point
        final Object proceed = joinPoint.proceed();
        //Advice
        final long executionTime = System.currentTimeMillis() - start;

        logger.info(" 	Around (anotación) {} Ejecutado en {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }

}
