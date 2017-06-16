package learn.design.pattern.observer.weather;

public class WeatherTest {
	public static void main(String[] args) {
		//1创建一个目标
		ConcreateWeatherSubject weather = new ConcreateWeatherSubject();
		//2创建观察者
		ConcreteWeatherObserver observerGirl = new ConcreteWeatherObserver();
		observerGirl.setObserverName("黄明的女朋友");
		observerGirl.setRemindThing("是我们的第一次约会，地点聂耳公园，不见不散哦！");
		
		ConcreteWeatherObserver observerMom = new ConcreteWeatherObserver();
		observerMom.setObserverName("黄明的老妈");
		observerMom.setRemindThing("是个购物的好日子，去购物真的好好啊！");
		//3注册观察者
		weather.attach(observerGirl);
		weather.attach(observerMom);
		//4目标发布天气
		weather.setSubjectState("明天天气明朗，蓝天白云，气温28度");
	}
}
