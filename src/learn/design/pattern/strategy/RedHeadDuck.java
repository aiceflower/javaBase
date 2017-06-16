package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingWithWin;

public class RedHeadDuck extends Duck {

	public RedHeadDuck(){
		super();
		super.setFlyingStrategy(new FlyingWithWin());
	}
	
	@Override
	public void display() {
		System.out.println("我的头是红色的");
	}

}
