package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingWithWin;

public class MallardDuck extends Duck {

	
	
	public MallardDuck() {
		super();
		super.setFlyingStrategy(new FlyingWithWin());
	}

	@Override
	public void display() {
		System.out.println("我的脖子是绿色的");
	}

}
