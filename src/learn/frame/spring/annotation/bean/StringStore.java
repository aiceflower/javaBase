package learn.frame.spring.annotation.bean;

public class StringStore implements Store {

	public void init(){
		System.out.println("test @bean init...");
	}
	
	
	public void destroy(){
		System.out.println("test @bean destroy...");
	}
}
