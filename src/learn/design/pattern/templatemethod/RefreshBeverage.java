package learn.design.pattern.templatemethod;

/**
 * 抽象基类，为所有子类提供一个算法框架
 * 
 * 提神饮料
 * @author Administrator
 *
 */
public abstract class RefreshBeverage {
	
	/**
	 *制备饮料的模板方法
	 *封装了所有子类共同的算法框架
	 *定义为final防止子类重写 
	 */
	public final void prepareBeverageTemplate(){
		//[1]将水煮沸
		boilWater();
		//[2]泡制饮料
		brew();
		//[3]将饮料倒入杯中
		pourInCup();
		//[4]加入调料,提供勾子，询问客户是否想加入饮料
		if(isCustomerWantsCondiments())
		addCondiments();
	}

	/**
	 * 加入调料
	 */
	protected abstract void addCondiments();

	private void pourInCup() {
		System.out.println("将饮料倒入杯中");
	}

	/**
	 * 泡制饮料
	 */
	protected abstract void brew() ;

	/**
	 * 将水渚沸
	 */
	private void boilWater() {
		System.out.println("将水渚沸");
	}
	
	//并不是所有的人都想往杯中加入饮料，故提供了勾子方法
	/**
	 * 询问客户是否加入调料
	 * Hook,勾子函数，提供一个空的或默认的实现
	 * 具体的子类可以自行决定是否挂钩以及如何挂钩
	 * @return
	 */
	protected  boolean isCustomerWantsCondiments(){
		return true;
	}
}
