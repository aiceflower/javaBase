package learn.design.pattern.templatemethod;

public class RefreshBeverageTest {
	public static void main(String[] args) {
		System.out.println("�Ʊ�����");
		RefreshBeverage rb = new Cofee();
		rb.prepareBeverageTemplate();
		System.out.println("�����ƺ���");
		System.out.println("---------------------------------");
		System.out.println("�Ʊ���");
		rb = new Tee();
		rb.prepareBeverageTemplate();
		System.out.println("���Ʊ����");
	}
}
