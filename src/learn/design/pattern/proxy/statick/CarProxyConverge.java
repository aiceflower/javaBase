package learn.design.pattern.proxy.statick;

/**
 * ͨ���ۺϴ���
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
		System.out.println("������ʼ��ʻ.......");
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("������ʻ�����������ܹ���ʻ�ˣ�"+(endTime-startTime)+"����");
	}
}
