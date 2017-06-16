package learn.design.pattern.strategy;

/**
 * 鸭子超类，所有鸭子都要继承此类
 * 抽象了鸭子的行为：显示和鸣叫
 * @author Administrator
 *
 */
public abstract class Duck {
	//组合鸭子的凯飞行行为
	private FlyingStrategy flyingStrategy;
	
	public Duck(){
		
	}
	
	
	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy = flyingStrategy;
	}
	

	/**
	 * 鸭子发出叫声，通用行为，由超类实现
	 */
	public void quack(){
		System.out.println("嘎嘎嘎嘎");
	}
	
	/**
	 * 显示鸭子外观
	 * 每个鸭子的外观都不相同，申明为抽象，由子类去实现
	 */
	public abstract void display();
	
	public void fly(){
		flyingStrategy.performFly();
	}
}
