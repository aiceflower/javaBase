package learn.frame.spring.service;

import learn.frame.spring.dao.AutoWiringDao;

public class AutoWiringService {
	AutoWiringDao autoWiringDao1;

	public AutoWiringService(){
		
	}
	
	/**
	 * �����Զ�װ��constructor,Ҳ��byType��bean��id�޹�
	 */
	public AutoWiringService(AutoWiringDao autoWiringDao){
		this.autoWiringDao1 = autoWiringDao;
	}
	
	/**
	 * �����Զ�װ��byName,����Ҫ�������ļ�������property,��Ҫ�������β���װ���bean��idһ��
	 * @param autoWiringDao
	 */
	public void setAutoWiringDao(AutoWiringDao autoWiringDao) {
		this.autoWiringDao1 = autoWiringDao;
	}
	
	public void say(String msg){
		autoWiringDao1.say(msg);
	}
}
