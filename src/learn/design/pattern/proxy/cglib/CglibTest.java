package learn.design.pattern.proxy.cglib;

public class CglibTest {
	public static void main(String[] args) {
		CglibProxy cp = new CglibProxy();
		Train t = (Train)cp.getProxy(Train.class);
		t.move();
	}
}
