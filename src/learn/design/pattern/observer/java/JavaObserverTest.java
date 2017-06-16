package learn.design.pattern.observer.java;


public class JavaObserverTest {
	public static void main(String[] args) {
		//1����Ŀ��
		ConcreateWeatherSubject subject = new ConcreateWeatherSubject();
		//2��������۲���
		ConcreateWeatherObserver observerGirl = new ConcreateWeatherObserver();
		observerGirl.setObserverName("Ů����");
		observerGirl.setRemindThing("�����ǵĵ�һ��Լ�ᣬ�ص�������԰��������ɢŶ��");
		
		ConcreateWeatherObserver observerMom = new ConcreateWeatherObserver();
		observerMom.setObserverName("����������");
		observerMom.setRemindThing("�Ǹ�����ĺ����ӣ�ȥ������ĺúð���");
		//3ע��۲���
		subject.addObserver(observerGirl);
		//subject.addObserver(observerMom);
		//4Ŀ�귢������
		subject.setWeatherContent("�����������ʣ�������ƣ�����28----------��");
	}
}
