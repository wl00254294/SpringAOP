package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.demo.annotation.Action;

@Aspect
@Component
public class AnnotationLogAspect {
	//@Pointcut("@annotation(com.example.demo.annotation.Action)")
    //public void annotationPointcut() {
    //}
	
	@Pointcut("execution(* com.example.demo.service ..*(..) )")
	public void servicePointcut(){
		
	}
	
	 @Before("servicePointcut()")
	 public void before(JoinPoint joinPoint) {
	   MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	   Method method = signature.getMethod();
	   Action action = method.getAnnotation(Action.class);
	   System.out.println("Annotatio is call BEFORE======>：" + action.name());
	 }

	 @Around("servicePointcut()") 
	 public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		   MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		   Method method = signature.getMethod();
		   Action action = method.getAnnotation(Action.class);
		   System.out.println("Service is calling ======>：" + action.name());
		   
		   return joinPoint.proceed();
     }
	 
	 @After("servicePointcut()")
	 public void after(JoinPoint joinPoint) {
	   MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	   Method method = signature.getMethod();
	   Action action = method.getAnnotation(Action.class);
	   System.out.println("Annotatio is call AFTER======>：" + action.name());
	 }
}
