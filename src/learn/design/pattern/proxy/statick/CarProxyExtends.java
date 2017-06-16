package learn.design.pattern.proxy.statick;

/**
 * 通过继承代理
 * @author Administrator
 *
 */
public class CarProxyExtends extends Car {
	
	@Override
	public void move(){
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶.......");
		super.move();	
		long endTime = System.currentTimeMillis();
		System.out.println("汽车行驶结束，车子总共行驶了："+(endTime-startTime)+"毫秒");
	}
}
