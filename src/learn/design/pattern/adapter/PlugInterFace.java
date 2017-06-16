package learn.design.pattern.adapter;

/**
 * 三相插座接口
 * @author Administrator
 *
 */
public interface PlugInterFace {
	
	//使用三相电流供电
	void powerWithThree(); 
	
	//使用二相电流供电
	void powerWithTwo();
}
