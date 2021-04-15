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

@Aspect
@Component
public class MyAspect {
	/**
	 * // @Before : Aspect description, code advice 
	 * @Before("execution(* fr.m2i.aspecttuto.service..*(..))" : pointCut expression
	 * public void beforeLogging(JoinPoint joinPoint){...} The pointCut signature
	 * A join point is in the service layer if the method is defined
	 * 
	 * URL: https://www.eclipse.org/aspectj/doc/released/progguide/semantics-pointcuts.html
	 * 
	 * Type name patterns :
	 * There is a special type name, *, which is also a type pattern. 
	 * " * " picks out all types, including primitive types. 
	 * Example : call(void foo(*))
	 * 
	 * Type patterns : *  ..
	 * The * wildcard matches zero or more characters characters except for "."
	 * The ".." wildcard matches any sequence of characters that start and end with a ".",
	 * so it can be used to pick out all types in any subpackage, or all inner types.
	 * Example : @Before("execution(* yassine.dev.service..* ")
	 * 
	 * @param joinPoint
	 * 
	 * @Before("execution(* yassine.dev.service..*(..))")
	 * Picks out (select) all join points where the code is in any method declaration 
	 * of a type whose name begins with "fr.m2i.aspecttuto.service., of any number of arguments (..).
	 */
	
	@Before("execution(* yassine.dev.service..*(..))")
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("\n*** Before running loggingAdvice on method " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* yassine.dev.service..*(..))")
	public void afterLogging(JoinPoint joinPoint) {
		System.out.println("*** After running loggingAdvice on method " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* yassine.dev.service.*.transfert(*,*,*))")
	public void beforeAdviceForTransfertMethod(JoinPoint joinPoint) {
		System.out.println("\n *** BeforeAdviceForTransfertMethod() " + joinPoint.getSignature().getName());
	}
	
	/**
	 * When using around we must call proceed method
	 * We use ProccedingJoinPoint as parameter of around advice
	 * Must ass throws Throwable
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* yassine.dev.service.*.checkBalance(*))") 
	public Double aroundAdviceForCheckBalanceMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("\n*** AroundAdviceForCheckBalanceMethod() " + joinPoint.getSignature().getName());
		Double balance = 0d;
		 try {
	    	  // On peut shunter l'appel de la méthode checkBalance
			/*
			 *  Calling proceed() on the ProceedingJoinPoint causes the underlying method to run. 
			 *  Comment the variable x to see the diference
			 */
	    	  balance = (Double) joinPoint.proceed();
	      } finally {
	    	 // Pour faire autre chose
	    	  balance = 5000d;
	      }
		return balance;

	}
	@AfterReturning("execution(* yassine.dev.service.*.withdrawal(*,*))")
	public void afterReturningLogging(JoinPoint joinPoint) {
		System.out.println("*** After returning exception loggingAdvice on method " +joinPoint.getSignature().getName());
	}
	@AfterThrowing("execution(* yassine.dev.service.*.deposite(*,*))")
	public void afterThrowingLogging(JoinPoint joinPoint) {
		System.out.println("*** After throwing exception loggingAdvice on method " +joinPoint.getSignature().getName());
	}
	
	// Annotation personnalisée : interface Log
	@After("@annotation(yassine.dev.aspect.Log)")
	public void afterWithCustomAnnotation(JoinPoint joinPoint) {
		System.out.println("*** Test after with custom Annotation " + joinPoint.getSignature().getName());
	}
}
