package learn.design.pattern.proxy.statick;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		//实现开车
		try{
			System.out.println("汽车行驶中...");
			Thread.sleep(new Random().nextInt(1000));
		}catch (InterruptedException e) {
			System.out.println("睡觉出现了异常");
		}
	}

}
