package learn.design.pattern.templatemethod;

public class Tee extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("�����ʼ��뱭��");

	}

	@Override
	protected void brew() {
		System.out.println("80�ȵ���ˮ�ݲ�");
	}

}
