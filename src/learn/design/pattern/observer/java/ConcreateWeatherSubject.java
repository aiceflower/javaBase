package learn.design.pattern.observer.java;

import java.util.Observable;

public class ConcreateWeatherSubject extends Observable {
	//目标观察者的内容
	private String weatherContent;

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.setChanged();
		this.notifyObservers(weatherContent);
	}
	
}
