package learn.design.pattern.observer.java;


public class JavaObserverTest {
	public static void main(String[] args) {
		//1创建目标
		ConcreateWeatherSubject subject = new ConcreateWeatherSubject();
		//2创建具体观察者
		ConcreateWeatherObserver observerGirl = new ConcreateWeatherObserver();
		observerGirl.setObserverName("女朋友");
		observerGirl.setRemindThing("是我们的第一次约会，地点聂耳公园，不见不散哦！");
		
		ConcreateWeatherObserver observerMom = new ConcreateWeatherObserver();
		observerMom.setObserverName("黄明的老妈");
		observerMom.setRemindThing("是个购物的好日子，去购物真的好好啊！");
		//3注册观察者
		subject.addObserver(observerGirl);
		//subject.addObserver(observerMom);
		//4目标发布天气
		subject.setWeatherContent("明天天气明朗，蓝天白云，气温28----------度");
	}
}
