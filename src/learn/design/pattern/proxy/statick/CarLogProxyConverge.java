package learn.design.pattern.proxy.statick;

public class CarLogProxyConverge implements Moveable{
	private Moveable car ;
	
	public CarLogProxyConverge(Moveable car){
		this.car = car;
	}
	@Override
	public void move() {
		System.out.println("��־��¼��ʼ...");
		car.move();
		System.out.println("��־��¼����...");
	}

}
