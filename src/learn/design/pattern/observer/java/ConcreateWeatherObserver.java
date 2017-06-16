package learn.design.pattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class ConcreateWeatherObserver implements Observer {

	// 名字
	private String observerName;
	// 内容
	private String weatherContent;
	//通知的事
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
		//推的方式
		System.out.println("推模型："+observerName+"收到了"+arg+","+remindThing);
		//拉的方式
		System.out.println("拉模型："+observerName+"收到了"+((ConcreateWeatherSubject)o).getWeatherContent()+","+remindThing);
	}

}
