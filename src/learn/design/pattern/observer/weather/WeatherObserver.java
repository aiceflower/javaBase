package learn.design.pattern.observer.weather;

/**
 * ����һ�������۲��߽ӿڣ�����һ�����µĽӿڸ���Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ķ���
 * @author Administrator
 *
 */
public interface WeatherObserver {
	//���������ӿڣ���ģ��
	void update(WeatherSubject ws);
	
	//��ģ��
	void putUpdate(String content);
}
