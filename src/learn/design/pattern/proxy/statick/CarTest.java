package learn.design.pattern.proxy.statick;

public class CarTest {
	public static void main(String[] args){
		//ʹ�ü̳еķ�ʽ
//		Moveable m = new CarProxyExtends();
//		m.move();
		
		//ʹ�þۺϵķ�ʽ
//		Car c = new Car();
//		Moveable car = new CarProxyConverge(c);
//		car.move();
		//ʹ�þۺϼ�¼��־��ʱ��
		Car car = new Car();
		CarLogProxyConverge clp = new CarLogProxyConverge(car);
		CarProxyConverge cp = new CarProxyConverge(clp);
		cp.move();
	}
}
