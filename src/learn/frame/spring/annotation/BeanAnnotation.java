package learn.frame.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class BeanAnnotation {
	public void say(String msg){
		System.out.println("beanAnnotation: "+msg);
	}
}
