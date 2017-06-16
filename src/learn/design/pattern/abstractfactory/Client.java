package learn.design.pattern.abstractfactory;

public class Client {
	public static void main(String[] args) {
		//ʥ��ϵ���к�
		MCFactory mc = new MCFactory();
		Boy boy = mc.getBoy();
		boy.drawBoy();
		
		System.out.println("-------------------------");
		
		//����ϵ��Ů��
		NYFactory ny = new NYFactory();
		Girl girl = ny.getGirl();
		girl.drowGirl();

		System.out.println("-------------------------");
		
		//����չ��Ϧϵ���к�Ů��
		QXFactory qx = new QXFactory();
		Boy qxBoy = qx.getBoy();
		Girl qxGirl = qx.getGirl();
		qxBoy.drawBoy();
		qxGirl.drowGirl();
	}
}
