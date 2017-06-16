package learn.design.pattern.templatemethod;

/**
 * 具体子类，提供了咖啡的具体实现
 * @author Administrator
 *
 */
public class Cofee extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("加入溏和牛奶");
	}

	@Override
	protected void brew() {
		System.out.println("用沸水冲泡咖啡");
	}

}
