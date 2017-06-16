package learn.design.pattern.observer.weather;


/**
 * 
 * @author Administrator
 *
 */
public class ConcreteWeatherObserver implements WeatherObserver{
	//�۲��ߵ����֣���˭�յ������ѶϢ��������Ů���ѣ�����������
	//����
	private String observerName;
	
	//���������ݣ������Ϣ��Ŀ�괦��ȡ
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

	//���ѵ����ݣ�������Ů��������Լ�ᣬ���������������ѹ���
	private String remindThing;
	
	/**
	 * ��ȡ���������ݣ�ͬ�����۲��ߵ�������(��ģ�ͣ�ͨ����ѣ�Ŀ����󴫸��۲���)
	 */
	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreateWeatherSubject)subject).getSubjectState();
		System.out.println("��ģ�ͣ�"+observerName+"�յ���"+weatherContent+","+remindThing);
	}

	//��ȡ�������ݣ���ģ�ͣ�
	@Override
	public void putUpdate(String content) {
		System.out.println("��ģ�ͣ�"+observerName+"�յ���"+content+","+remindThing);
	}
}
