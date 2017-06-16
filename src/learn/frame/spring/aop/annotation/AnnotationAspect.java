package learn.frame.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AnnotationAspect {

	/**
	 * 定义一个切入点
	 */
	@Pointcut("execution(* learn.frame.spring.aop.annotation.TestAopAnnotationBiz.*(..))")
	public void anyMethod(){}
	/**
	 * 方法运行前前
	 */
	@Before("anyMethod()")
	public void before(){
		System.out.println("test aop annotation running before...");
		System.out.println("	test none...");
	}
	
	/**
	 * 方法运行前后（环绕）  这个方法的第一个参数必须是ProceedingJoinPoint类型
	 * @param pjp
	 * @return
	 */
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp){
		System.out.println("		test aop annotation running up...");
		Object proceed=null;
		try {
			proceed = pjp.proceed();
		} catch (Throwable e) {
		}
		System.out.println("		test aop annotation running down...");
		return proceed;
	}
	
	/**
	 * 方法运行且返回后，如果抛出异常则还没有返回
	 */
	@AfterReturning("anyMethod()")
	public void afterReturning(){
		System.out.println("	test aop annotation after returning...");
	}
	
	/**
	 * 抛出异常后
	 */
	@AfterThrowing("anyMethod()")
	public void throingException(){
		System.out.println("	test aop annotation after throwing exception...");
	}
	
	/**
	 * 方法运行后 
	 */
	@After("anyMethod()")
	public void after(){
		System.out.println("test aop annotation running after");
	}
	
	/**
	 * 带参数的环绕
	 * @param pjp 必须的参数
	 * @param str 目标方法的第一个参数，名字要一致
	 * @param it 目标方法的第二个参数，名字要一致
	 */
	@Around("anyMethod() && args(str,it)")
	public void roundParam(ProceedingJoinPoint pjp,String str,int it){
		System.out.println("。。。annotation"+str+"。。。"+it+"。。。up");
		try {
			Object proceed = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("。。。annotation"+str+"。。。"+it+"。。。down");
		
	}

}
