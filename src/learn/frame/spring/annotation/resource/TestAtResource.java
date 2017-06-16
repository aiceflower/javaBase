package learn.frame.spring.annotation.resource;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TestAtResource {
	
	@Resource
	private Calendar d;

//	public void setD(Calendar d) {
//		this.d = d;
//	}
	
	public void testAtResource(){
		System.out.println(d);
	}
	
}
