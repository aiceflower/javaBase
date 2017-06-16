package learn.frame.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestApplicationContext implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.applicationContext = context;
		System.out.println("applicationContext: "+context.getBean("testApplicationContext").hashCode());
	}
	
	//�����Ϳ��Ի�ȡapplictionContext��
	public ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
}
