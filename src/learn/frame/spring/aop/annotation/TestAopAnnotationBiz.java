package learn.frame.spring.aop.annotation;


public class TestAopAnnotationBiz {
	/**
	 * 测试。。。
	 */
	public void biz(){
		System.out.println("			...annotation here do some biz...");
		//模拟异常
		//throw new RuntimeException();
	}
	
	/**
	 * 测试带参数的环绕
	 * @param str
	 * @param it
	 */
	public void bizParam(String str,int it){
		System.out.println("			...annotation here do some biz "+str+" "+it);
	}
}
