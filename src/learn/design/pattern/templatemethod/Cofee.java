package learn.design.pattern.templatemethod;

/**
 * �������࣬�ṩ�˿��ȵľ���ʵ��
 * @author Administrator
 *
 */
public class Cofee extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("�������ţ��");
	}

	@Override
	protected void brew() {
		System.out.println("�÷�ˮ���ݿ���");
	}

}
