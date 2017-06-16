package learn.design.pattern.observer.weather;


/**
 * 
 * @author Administrator
 *
 */
public class ConcreteWeatherObserver implements WeatherObserver{
	//观察者的名字，是谁收到了这个讯息，黄明的女朋友，还是他老妈
	//名字
	private String observerName;
	
	//天气的内容，这个消息从目标处获取
	private String weatherContent;
	
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

	//提醒的内容，黄明的女朋友提醒约会，而他的老妈则提醒购物
	private String remindThing;
	
	/**
	 * 获取天气的内容，同步到观察者的内容中(拉模型，通常会把，目标对象传给观察者)
	 */
	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreateWeatherSubject)subject).getSubjectState();
		System.out.println("拉模型："+observerName+"收到了"+weatherContent+","+remindThing);
	}

	//获取天气内容（推模型）
	@Override
	public void putUpdate(String content) {
		System.out.println("推模型："+observerName+"收到了"+content+","+remindThing);
	}
}
