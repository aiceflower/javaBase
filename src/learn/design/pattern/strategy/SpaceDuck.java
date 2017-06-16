package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingWithRocket;

public class SpaceDuck extends Duck {

	public SpaceDuck(){
		super();
		super.setFlyingStrategy(new FlyingWithRocket());
	}
	
	@Override
	public void display() {
		System.out.println("我头带宇航头盔");
	}
	
	public void quack(){
		System.out.println("我通过无线电与你通信");
	}
}
