package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingNowWay;

/**
 * 大黄鸭
 * @author Administrator
 *
 */
public class BigYellowDuck extends Duck {

	public BigYellowDuck(){
		super();
		super.setFlyingStrategy(new FlyingNowWay());
	}
	
	@Override
	public void display() {
		System.out.println("我身体很大，全身黄黄");
	}
	
	//不会叫
	@Override
	public void quack(){
		System.out.println("我不会叫");
	}
}
