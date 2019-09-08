package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {
	
	//@Around("execution(* com.example.demo.*Service.*(..))") ==> 모든 service에 적용됨 
	//@Around("@annotation(PerfLogging)")
	@Around("bean(simplePlayService)")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		long begin = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		System.out.print("aspect around 적용 : [");
		System.out.print(System.currentTimeMillis() - begin);
		System.out.print("]");
		System.out.println();
		return retVal;
	}
	
	@Before("bean(simplePlayService)")
	public void beforeLogging() {
		System.out.println("hello before log");
	}
}
