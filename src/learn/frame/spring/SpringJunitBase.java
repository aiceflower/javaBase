package learn.frame.spring;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJunitBase {
	
	private String springXmlPath;
	private ClassPathXmlApplicationContext context;
	
	public SpringJunitBase(){}
	
	public SpringJunitBase(String springXmlPath){
		this.springXmlPath = springXmlPath;
	}
	
	@Before
	public void before(){
		if(springXmlPath==null||"".equals(springXmlPath)){
			springXmlPath = "classpath*:spring-*.xml";
		}
		try{
			context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]"));
			context.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after(){
		context.destroy();
	}
	
	/**
	 * ��ȡbean����
	 * @param beanName bean��id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends Object> T getBean(String beanName){
		//���Բ���ǿת��
		return (T)context.getBean(beanName);
	}
}
