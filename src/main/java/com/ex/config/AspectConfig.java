package com.ex.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class AspectConfig {
	
	private final Logger logger = LoggerFactory.getLogger(AspectConfig.class);
	
	static String name = "";
	static String type = "";
	
	@Before("execution(* com.ex..controller.*Controller.*(..))")
	public void doBefore(JoinPoint joinPoint) {
		
		logger.info("================== START ==================");
		
		type = joinPoint.getSignature().getDeclaringTypeName();
		
		if(type.indexOf("Controller") > -1) {
			name = "Controller	\t:	";
		}
		else if(type.indexOf("Service") > -1) {
			name = "ServiceImpl	\t:	";
		}
		else if(type.indexOf("DAO") > -1) {
			name = "DAO	\t\t:	";
		}
		logger.info(name + type + "." +joinPoint.getSignature().getName() +"()");
	}
	
	@After("execution(* com.ex..controller.*Controller.*(..))")
	public void doAfter(JoinPoint joinPoint) {
		
		logger.info("=================== END ===================");
		
	}

}
