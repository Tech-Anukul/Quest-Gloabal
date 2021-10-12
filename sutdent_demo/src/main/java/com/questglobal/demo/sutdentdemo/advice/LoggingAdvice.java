package com.questglobal.demo.sutdentdemo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
public class LoggingAdvice {
	
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	@Pointcut(value = "execution(public *com.questglobal.demo.sutdentdemo.*.*.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint)  {
		ObjectMapper mapper = new ObjectMapper();
		String method_name = joinPoint.getSignature().getName();
		String class_name = joinPoint.getTarget().toString();
		Object object = null;
		try {
			object = joinPoint.proceed();
			log.info(class_name + " : " + method_name + "()" + "Response : "
					+ mapper.writeValueAsString(object));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return object;
	}
}
