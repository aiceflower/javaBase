package learn.design.pattern.proxy.statick;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		//ʵ�ֿ���
		try{
			System.out.println("������ʻ��...");
			Thread.sleep(new Random().nextInt(1000));
		}catch (InterruptedException e) {
			System.out.println("˯���������쳣");
		}
	}

}
