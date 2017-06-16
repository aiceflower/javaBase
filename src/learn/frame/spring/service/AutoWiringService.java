package learn.frame.spring.service;

import learn.frame.spring.dao.AutoWiringDao;

public class AutoWiringService {
	AutoWiringDao autoWiringDao1;

	public AutoWiringService(){
		
	}
	
	/**
	 * 测试自动装配constructor,也是byType跟bean的id无关
	 */
	public AutoWiringService(AutoWiringDao autoWiringDao){
		this.autoWiringDao1 = autoWiringDao;
	}
	
	/**
	 * 测试自动装配byName,不需要在配置文件中配置property,需要方法的形参与装配的bean的id一致
	 * @param autoWiringDao
	 */
	public void setAutoWiringDao(AutoWiringDao autoWiringDao) {
		this.autoWiringDao1 = autoWiringDao;
	}
	
	public void say(String msg){
		autoWiringDao1.say(msg);
	}
}
