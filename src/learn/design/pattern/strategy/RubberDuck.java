package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingNowWay;

public class RubberDuck extends Duck {

	public RubberDuck(){
		super();
		super.setFlyingStrategy(new FlyingNowWay());
	}
	
	@Override
	public void display() {
		System.out.println("我全身发黄，嘴吧很红");
	}
	
	@Override
	public void quack(){
		System.out.println("嘎~嘎~嘎");
	}
}
