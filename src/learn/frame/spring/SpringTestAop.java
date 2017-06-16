package learn.frame.spring;

import learn.frame.spring.aop.AspectBiz;
import learn.frame.spring.aop.Fit;
import learn.frame.spring.aop.annotation.TestAopAnnotationBiz;

import org.junit.Test;

public class SpringTestAop extends SpringJunitBase{
	
	public SpringTestAop(){
		super("applicationContext.xml");
	}
	
	/**
	 * ����AOP����
	 */
	@Test
	public void testAdvice(){
		AspectBiz ab = super.getBean("aspectBiz");
		ab.biz();
	}
	
	/**
	 * ���Դ������Ļ���
	 */
	@Test
	public void testRoundParam(){
		AspectBiz ab = super.getBean("aspectBiz");
		ab.bizParam("String", 100);
	}
	/**
	 * ���Ը�һ����ǿ����Ӹ���
	 */
	@Test
	public void testFit(){
		//AaspectBizδʵ��Fit�ӿڣ���ȷǿת�ɹ���
		Fit fit = (Fit)super.getBean("aspectBiz");
		fit.filter();
	}
	
	/**
	 * ����aopע��
	 */
	@Test
	public void testAnnotationAop(){
		TestAopAnnotationBiz ta = super.getBean("testAopAnnotationBiz");
		ta.biz();
	}
}
