package com.zee.zee5app.aop;

import javax.persistence.criteria.Join;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect //a container which will hold all aop code 
public class UserServiceAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	//pointcut: a expression that select one or more join points where advice is executed
	// advice: action that we take before or after the mrthod execution
	@Pointcut("within(@org.springframework.stereotype.Repository *)" +
	"|| within(@org.springframework.stereotype.Service *)" 
			+ "|| within(@org.springframework.web.bind.annotation.RestController *)")
	
	public void springPointCutExp()
	{
		
	}
	
	
	
	//for classes-> specifying the package name
	// ..* => is used to implement everything 
	@Pointcut("within(com.zee.zee5app.controller..*)" +
			"|| within(com.zee.zee5app.service.Impl..*)" )
					
	public void springPointCutExp2()
	{
				
	}
	
	
	
	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing="e")
	public void logAfterThrowingException(JoinPoint joinPoint, Throwable e)
	{
		log.error("exception {}, {} () with cause {}",joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause():"NULL");
	}
	
	//@Around(value = ) find use case for around --assignment given
	//execute bbefore and after a join point
	//why they provide around if before and after is there? => can excute same program twice but b4 and after customize
	
	@Before(value = "execution(* com.zee.zee5app.serviceImpl.*.*(..))")
	public void beforeAllServiceMethods(JoinPoint joinPoint)
	{
		System.out.println("hello");
		System.out.println(joinPoint);
	}
	
	/*
	 * How aspect will work internally? :through AOP proxy(starter dependency which will bring spring aop, spring boot starter aop and spring aspect)
	 * AOP will get the access of the container(Aspect container) via spring aop proxy. 
	 * Transactions will be managed internally, who took care? taken care by spring AOP.(@Transaction is nothing but AOP)
	 */
	
	/*
	 * sl4j library is used for writing the logs
	 */
	
	/*
	 * Join point: A point in the application where we apply an AOP aspect. `
	 *             In AOP a point can be a method execution, exception handling.
	 */
}
