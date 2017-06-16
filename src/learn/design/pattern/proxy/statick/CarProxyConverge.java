package learn.design.pattern.proxy.statick;

/**
 * 通过聚合代理
 * @author Administrator
 *
 */
public class CarProxyConverge implements Moveable{
	
	private Moveable car;
	
	public CarProxyConverge(Moveable car){
		this.car = car;
	}
	
	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶.......");
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车行驶结束，车子总共行驶了："+(endTime-startTime)+"毫秒");
	}
}
