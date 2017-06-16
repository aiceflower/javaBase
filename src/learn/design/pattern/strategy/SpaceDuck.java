package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingWithRocket;

public class SpaceDuck extends Duck {

	public SpaceDuck(){
		super();
		super.setFlyingStrategy(new FlyingWithRocket());
	}
	
	@Override
	public void display() {
		System.out.println("��ͷ���ͷ��");
	}
	
	public void quack(){
		System.out.println("��ͨ�����ߵ�����ͨ��");
	}
}
