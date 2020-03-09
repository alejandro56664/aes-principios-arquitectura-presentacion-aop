package com.principios.ejemplo.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.principios.ejemplo.business.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		//Advice
		logger.info("	Despues de retornar el joint-point: '{}' retornó con el valor '{}'", joinPoint, result);
	}
	
	@After(value = "execution(* com.principios.ejemplo.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		//Advice
		logger.info("	Despues de la ejecución de: '{}'", joinPoint);
	}
}