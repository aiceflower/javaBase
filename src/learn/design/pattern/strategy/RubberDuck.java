package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingNowWay;

public class RubberDuck extends Duck {

	public RubberDuck(){
		super();
		super.setFlyingStrategy(new FlyingNowWay());
	}
	
	@Override
	public void display() {
		System.out.println("��ȫ���ƣ���ɺܺ�");
	}
	
	@Override
	public void quack(){
		System.out.println("��~��~��");
	}
}
