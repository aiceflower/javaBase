package learn.design.pattern.observer.weather;

/**
 * 这是一个天气观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 * @author Administrator
 *
 */
public interface WeatherObserver {
	//更新天气接口，拉模型
	void update(WeatherSubject ws);
	
	//推模型
	void putUpdate(String content);
}
