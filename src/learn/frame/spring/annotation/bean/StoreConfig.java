package learn.frame.spring.annotation.bean;

//@Configuration
public class StoreConfig {
	
	//@Bean(name="stringStore",init-method="init",destroy-method="destroy")
	public Store getStringStore(){
		return new StringStore();
	}
	/*
	 *����������ȥ�ã���������汾��spring��jar���в�֧�� 
	 */
}
