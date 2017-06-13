package com.mycompany.myapp.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component
@Aspect
public class LoginCheckAspect {
	// Pointcut
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam14AopController.exam02*(..))")
	private void exam02Method() {
		
	}
	
	// Advice
	@Around("exam02Method()")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// before code
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		String mid = (String) requestAttributes.getAttribute("mid", RequestAttributes.SCOPE_SESSION);
		if(mid == null) {
			requestAttributes.setAttribute("loginNeed","로그인이 필요합니다.", RequestAttributes.SCOPE_SESSION);
			//session.setAttribute("loginNeed", "로그인이 필요합니다.");
			//request.setAttribute("key", "value");
			return "aop/exam02LoginForm";
		} else {
			// 메소드 결과값이 저장됨
			Object method = joinPoint.proceed();
			return method;
		}
		
		// after code
	}
}
