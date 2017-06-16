package learn.design.pattern.proxy.statick;

public class CarLogProxyConverge implements Moveable{
	private Moveable car ;
	
	public CarLogProxyConverge(Moveable car){
		this.car = car;
	}
	@Override
	public void move() {
		System.out.println("日志记录开始...");
		car.move();
		System.out.println("日志记录结束...");
	}

}
