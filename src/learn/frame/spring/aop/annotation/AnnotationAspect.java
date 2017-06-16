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
	 * ����һ�������
	 */
	@Pointcut("execution(* learn.frame.spring.aop.annotation.TestAopAnnotationBiz.*(..))")
	public void anyMethod(){}
	/**
	 * ��������ǰǰ
	 */
	@Before("anyMethod()")
	public void before(){
		System.out.println("test aop annotation running before...");
		System.out.println("	test none...");
	}
	
	/**
	 * ��������ǰ�󣨻��ƣ�  ��������ĵ�һ������������ProceedingJoinPoint����
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
	 * ���������ҷ��غ�����׳��쳣��û�з���
	 */
	@AfterReturning("anyMethod()")
	public void afterReturning(){
		System.out.println("	test aop annotation after returning...");
	}
	
	/**
	 * �׳��쳣��
	 */
	@AfterThrowing("anyMethod()")
	public void throingException(){
		System.out.println("	test aop annotation after throwing exception...");
	}
	
	/**
	 * �������к� 
	 */
	@After("anyMethod()")
	public void after(){
		System.out.println("test aop annotation running after");
	}
	
	/**
	 * �������Ļ���
	 * @param pjp ����Ĳ���
	 * @param str Ŀ�귽���ĵ�һ������������Ҫһ��
	 * @param it Ŀ�귽���ĵڶ�������������Ҫһ��
	 */
	@Around("anyMethod() && args(str,it)")
	public void roundParam(ProceedingJoinPoint pjp,String str,int it){
		System.out.println("������annotation"+str+"������"+it+"������up");
		try {
			Object proceed = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("������annotation"+str+"������"+it+"������down");
		
	}

}
