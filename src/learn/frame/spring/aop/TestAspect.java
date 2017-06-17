package learn.frame.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {

	/**
	 * 方法运行前前
	 */
	public void before(){
		System.out.println("test aop running before...");
		System.out.println("	test none...");
	}
	
	/**
	 * 方法运行前后（环绕）  这个方法的第一个参数必须是ProceedingJoinPoint类型
	 * @param pjp
	 * @return
	 */
	public Object doBasicProfiling(ProceedingJoinPoint pjp){
		System.out.println("		test aop running up...");
		Object proceed=null;
		try {
			proceed = pjp.proceed();
		} catch (Throwable e) {
		}
		System.out.println("		test aop running down...");
		return proceed;
	}
	
	/**
	 * 方法运行且返回后，如果抛出异常则还没有返回
	 */
	public void afterReturning(){
		System.out.println("	test aop after returning...");
	}
	
	/**
	 * 抛出异常后
	 */
	public void throingException(){
		System.out.println("	test aop after throwing exception...");
	}
	
	/**
	 * 方法运行后 
	 */
	public void after(){
		System.out.println("test aop running after");
	}
	
	/**
	 * 带参数的环绕
	 * @param pjp 必须的参数
	 * @param str 目标方法的第一个参数，名字要一致
	 * @param it 目标方法的第二个参数，名字要一致
	 */
	@SuppressWarnings("unused")
	public void roundParam(ProceedingJoinPoint pjp,String str,int it){
		System.out.println("。。。"+str+"。。。"+it+"。。。up");
		try {
			Object proceed = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("。。。"+str+"。。。"+it+"。。。down");
		
	}
}
