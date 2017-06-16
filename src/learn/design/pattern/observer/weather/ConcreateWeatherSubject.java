package learn.design.pattern.observer.weather;

public class ConcreateWeatherSubject extends WeatherSubject{
	//目标观察者的状态
	private String weatherContent;

	public String getSubjectState() {
		return weatherContent;
	}

	public void setSubjectState(String weatherContent) {
		this.weatherContent = weatherContent;
		//内容有了 说明天气更新了，通知所有的订阅的人
		//this.notifyObservers();拉
		this.notifyObservers(weatherContent);
	}
}
