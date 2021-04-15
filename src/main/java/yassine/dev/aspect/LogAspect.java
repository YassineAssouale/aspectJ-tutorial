package yassine.dev.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class LogAspect{
	/**
	 * // @Before : Aspect description, code advice 
	 * "execution(* fr.m2i.aspecttuto.service..*(..))" : pointCut
	 * @param joinPoint
	 */
	@Before("execution(* yassine.dev.service..*(..))")
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("\n***Before running loggingAdvice on method " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* yassine.dev.service..*(..))")
	public void afterLogging(JoinPoint joinPoint) {
		System.out.println("\n***After running loggingAdvice on method " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* yassine.dev.service.*.transfert(*,*,*))")
	public void beforeAdviceForTransferMethod(JoinPoint joinPoint) {
		System.out.println("\n***BeforeAdviceForTransferMethod() " + joinPoint.getSignature().getName());
	}
	@Around("execution(* yassine.dev.service.*.checkBalance(*))")
	public Double aroundAdviceForCheckBalanceMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("\n***AroundAdviceFocCheckBalanceMethod()" + joinPoint.getSignature().getName() + " - Before method execution");
		Double balance = 0d;
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			balance = 5000d;
		}
		
		System.out.println("\n*** aroundAdviceForCheckBalanceMethod() " + joinPoint.getSignature().getName() + " - After method execution");
	    return balance;
	}
	
	@AfterThrowing("execution(* yassine.dev.service.*.deposite(*,*))")
	public void afterThrowingLogging(JoinPoint joinPoint) {
		System.out.println("***After Throwing exception running loggingAdvice on method " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* yassine.dev.service.*.deposite(*,*))")
	public void afterReturningLogging(JoinPoint joinPoint) {
		System.out.println("**** After returning running loggingAdvice on method " + joinPoint.getSignature().getName());
	}
	

	
}
