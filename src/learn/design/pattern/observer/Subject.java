package learn.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲��ߵĽӿ�
 * @author Administrator
 *
 */
public class Subject {
	//��������ע��Ĺ۲��߶���
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * ���֪ͨ�Ĺ۲��߶���
	 * @param obs
	 */
	public void attach(Observer obs){
		observers.add(obs);
	}
	
	/**
	 * ɾ��ָ���Ĺ۲��߶���
	 * @param obs
	 */
	public void detach(Observer obs){
		observers.remove(obs);
	}
	
	/**
	 * ֪ͨ����ע��Ĺ۲��߶���
	 */
	protected void  notifyObservers() {
		for(Observer obs:observers){
			obs.update(this);
		}
	}
}
