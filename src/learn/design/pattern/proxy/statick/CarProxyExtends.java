package learn.design.pattern.proxy.statick;

/**
 * ͨ���̳д���
 * @author Administrator
 *
 */
public class CarProxyExtends extends Car {
	
	@Override
	public void move(){
		long startTime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ.......");
		super.move();	
		long endTime = System.currentTimeMillis();
		System.out.println("������ʻ�����������ܹ���ʻ�ˣ�"+(endTime-startTime)+"����");
	}
}
