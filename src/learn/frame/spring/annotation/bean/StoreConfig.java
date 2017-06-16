package learn.frame.spring.annotation.bean;

//@Configuration
public class StoreConfig {
	
	//@Bean(name="stringStore",init-method="init",destroy-method="destroy")
	public Store getStringStore(){
		return new StringStore();
	}
	/*
	 *正常是这样去用，但在这个版本的spring的jar包中不支持 
	 */
}
