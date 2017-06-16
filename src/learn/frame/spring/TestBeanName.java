package learn.frame.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestBeanName implements BeanNameAware, ApplicationContextAware {
    private	String beanName;
    
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("beanName: "+applicationContext.getBean(this.beanName).hashCode());
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("beanName: "+beanName);
	}

}
