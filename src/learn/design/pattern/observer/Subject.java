package learn.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 * @author Administrator
 *
 */
public class Subject {
	//用来保存注册的观察者对象
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 添加通知的观察者对象
	 * @param obs
	 */
	public void attach(Observer obs){
		observers.add(obs);
	}
	
	/**
	 * 删除指定的观察者对象
	 * @param obs
	 */
	public void detach(Observer obs){
		observers.remove(obs);
	}
	
	/**
	 * 通知所有注册的观察者对象
	 */
	protected void  notifyObservers() {
		for(Observer obs:observers){
			obs.update(this);
		}
	}
}
