package learn.design.pattern.observer.weather;

public class ConcreateWeatherSubject extends WeatherSubject{
	//Ŀ��۲��ߵ�״̬
	private String weatherContent;

	public String getSubjectState() {
		return weatherContent;
	}

	public void setSubjectState(String weatherContent) {
		this.weatherContent = weatherContent;
		//�������� ˵�����������ˣ�֪ͨ���еĶ��ĵ���
		//this.notifyObservers();��
		this.notifyObservers(weatherContent);
	}
}
