package learn.design.pattern.observer.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {

	/**
	 * 天气目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
	 * @author Administrator
	 *
	 */
	// 用来保存注册的观察者对象
	private List<WeatherObserver> observers = new ArrayList<WeatherObserver>();

	/**
	 * 把订阅天气的人添加到订阅者列表中
	 * 
	 * @param obs
	 */
	public void attach(WeatherObserver obs) {
		observers.add(obs);
	}

	/**
	 * 删除指定的订阅天气的人
	 * 
	 * @param obs
	 */
	public void detach(WeatherObserver obs) {
		observers.remove(obs);
	}

	/**
	 * （拉模型）
	 * 通知所有注册的观察者对象
	 */
//	protected void notifyObservers() {
//		for (WeatherObserver obs : observers) {
//			obs.update(this);
//		}
//	}
	
	/**
	 * （推模型）
	 * @param content推送的内容
	 */
	protected void notifyObservers(String content) {
		for(WeatherObserver obs :observers){
			obs.putUpdate(content);
		}
	}
}
