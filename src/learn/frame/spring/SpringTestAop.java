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
	 * 测试AOP切面
	 */
	@Test
	public void testAdvice(){
		AspectBiz ab = super.getBean("aspectBiz");
		ab.biz();
	}
	
	/**
	 * 测试带参数的环绕
	 */
	@Test
	public void testRoundParam(){
		AspectBiz ab = super.getBean("aspectBiz");
		ab.bizParam("String", 100);
	}
	/**
	 * 测试给一个类强制添加父类
	 */
	@Test
	public void testFit(){
		//AaspectBiz未实现Fit接口，但确强转成功了
		Fit fit = (Fit)super.getBean("aspectBiz");
		fit.filter();
	}
	
	/**
	 * 测试aop注解
	 */
	@Test
	public void testAnnotationAop(){
		TestAopAnnotationBiz ta = super.getBean("testAopAnnotationBiz");
		ta.biz();
	}
}
