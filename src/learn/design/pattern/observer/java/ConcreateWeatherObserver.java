package learn.design.pattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class ConcreateWeatherObserver implements Observer {

	// ����
	private String observerName;
	// ����
	private String weatherContent;
	//֪ͨ����
	private String remindThing;
	
	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}

	@Override
	public void update(Observable o, Object arg) {
		//�Ƶķ�ʽ
		System.out.println("��ģ�ͣ�"+observerName+"�յ���"+arg+","+remindThing);
		//���ķ�ʽ
		System.out.println("��ģ�ͣ�"+observerName+"�յ���"+((ConcreateWeatherSubject)o).getWeatherContent()+","+remindThing);
	}

}
