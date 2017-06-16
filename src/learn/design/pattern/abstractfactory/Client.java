package learn.design.pattern.abstractfactory;

public class Client {
	public static void main(String[] args) {
		//圣诞系列男孩
		MCFactory mc = new MCFactory();
		Boy boy = mc.getBoy();
		boy.drawBoy();
		
		System.out.println("-------------------------");
		
		//新年系列女孩
		NYFactory ny = new NYFactory();
		Girl girl = ny.getGirl();
		girl.drowGirl();

		System.out.println("-------------------------");
		
		//后扩展七夕系列男孩女孩
		QXFactory qx = new QXFactory();
		Boy qxBoy = qx.getBoy();
		Girl qxGirl = qx.getGirl();
		qxBoy.drawBoy();
		qxGirl.drowGirl();
	}
}
