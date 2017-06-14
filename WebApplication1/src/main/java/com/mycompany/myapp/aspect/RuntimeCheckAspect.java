package com.mycompany.myapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RuntimeCheckAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeCheckAspect.class);
	// PointCut
	// 아래 명령어 의미: ()안의 메소드(public이여야하며 리턴타입은 관계없음.패키지안에 있는 클래스.*의 경우(아니면 지정 이름으로 시작되는 메소드) 그 안의 모든 메소드(메소드는 (..)이걸로 표시))를 실행을 할 때 다음의 pointcut을 실행하라는 의미!
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam12DBController.*(..))")
	private void runtimeCheckMethod() {
		
	}
	
	// Advice
	// AroundAdvice를 적용해줄 메소드를 지정할 때 @Pointcut 이 어노테이션을 넣을 수가 없기에 이 어노테이션을 적용한 메소드 이름을 넣어줌.
	// 실제로 적용되는 메소드는 Pointcut 괄호 안의 메소드
	@Around("runtimeCheckMethod()")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// before code
		// 아래 코드는 execution괄호 안의 클래스에 있는 메소드를 찾는다.
		long startTime = System.nanoTime();
		
		// 실제 메소드 호출(realMethod 호출)
		Object method = joinPoint.proceed();
		
		// after code
		long endTime = System.nanoTime();
		long time = endTime - startTime;
		String realMethod = joinPoint.getSignature().toShortString();
		LOGGER.info(realMethod + "실행 시간: " + time +"ns"); 
		
		return method;
	}
}