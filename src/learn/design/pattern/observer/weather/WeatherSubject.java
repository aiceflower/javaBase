package learn.design.pattern.observer.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {

	/**
	 * ����Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲��ߵĽӿ�
	 * @author Administrator
	 *
	 */
	// ��������ע��Ĺ۲��߶���
	private List<WeatherObserver> observers = new ArrayList<WeatherObserver>();

	/**
	 * �Ѷ�������������ӵ��������б���
	 * 
	 * @param obs
	 */
	public void attach(WeatherObserver obs) {
		observers.add(obs);
	}

	/**
	 * ɾ��ָ���Ķ�����������
	 * 
	 * @param obs
	 */
	public void detach(WeatherObserver obs) {
		observers.remove(obs);
	}

	/**
	 * ����ģ�ͣ�
	 * ֪ͨ����ע��Ĺ۲��߶���
	 */
//	protected void notifyObservers() {
//		for (WeatherObserver obs : observers) {
//			obs.update(this);
//		}
//	}
	
	/**
	 * ����ģ�ͣ�
	 * @param content���͵�����
	 */
	protected void notifyObservers(String content) {
		for(WeatherObserver obs :observers){
			obs.putUpdate(content);
		}
	}
}
