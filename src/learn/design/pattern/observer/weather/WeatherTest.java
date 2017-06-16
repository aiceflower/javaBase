package learn.design.pattern.observer.weather;

public class WeatherTest {
	public static void main(String[] args) {
		//1����һ��Ŀ��
		ConcreateWeatherSubject weather = new ConcreateWeatherSubject();
		//2�����۲���
		ConcreteWeatherObserver observerGirl = new ConcreteWeatherObserver();
		observerGirl.setObserverName("������Ů����");
		observerGirl.setRemindThing("�����ǵĵ�һ��Լ�ᣬ�ص�������԰��������ɢŶ��");
		
		ConcreteWeatherObserver observerMom = new ConcreteWeatherObserver();
		observerMom.setObserverName("����������");
		observerMom.setRemindThing("�Ǹ�����ĺ����ӣ�ȥ������ĺúð���");
		//3ע��۲���
		weather.attach(observerGirl);
		weather.attach(observerMom);
		//4Ŀ�귢������
		weather.setSubjectState("�����������ʣ�������ƣ�����28��");
	}
}
