package learn.design.pattern.proxy.statick;

public class CarTest {
	public static void main(String[] args){
		//使用继承的方式
//		Moveable m = new CarProxyExtends();
//		m.move();
		
		//使用聚合的方式
//		Car c = new Car();
//		Moveable car = new CarProxyConverge(c);
//		car.move();
		//使用聚合记录日志跟时间
		Car car = new Car();
		CarLogProxyConverge clp = new CarLogProxyConverge(car);
		CarProxyConverge cp = new CarProxyConverge(clp);
		cp.move();
	}
}
