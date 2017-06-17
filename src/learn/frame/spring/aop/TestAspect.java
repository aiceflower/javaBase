package learn.frame.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {

	/**
	 * ��������ǰǰ
	 */
	public void before(){
		System.out.println("test aop running before...");
		System.out.println("	test none...");
	}
	
	/**
	 * ��������ǰ�󣨻��ƣ�  ��������ĵ�һ������������ProceedingJoinPoint����
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
	 * ���������ҷ��غ�����׳��쳣��û�з���
	 */
	public void afterReturning(){
		System.out.println("	test aop after returning...");
	}
	
	/**
	 * �׳��쳣��
	 */
	public void throingException(){
		System.out.println("	test aop after throwing exception...");
	}
	
	/**
	 * �������к� 
	 */
	public void after(){
		System.out.println("test aop running after");
	}
	
	/**
	 * �������Ļ���
	 * @param pjp ����Ĳ���
	 * @param str Ŀ�귽���ĵ�һ������������Ҫһ��
	 * @param it Ŀ�귽���ĵڶ�������������Ҫһ��
	 */
	@SuppressWarnings("unused")
	public void roundParam(ProceedingJoinPoint pjp,String str,int it){
		System.out.println("������"+str+"������"+it+"������up");
		try {
			Object proceed = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("������"+str+"������"+it+"������down");
		
	}
}
