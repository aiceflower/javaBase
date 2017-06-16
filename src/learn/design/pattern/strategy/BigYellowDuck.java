package learn.design.pattern.strategy;

import learn.design.pattern.strategy.impl.FlyingNowWay;

/**
 * ���Ѽ
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
		System.out.println("������ܴ�ȫ��ƻ�");
	}
	
	//�����
	@Override
	public void quack(){
		System.out.println("�Ҳ����");
	}
}
