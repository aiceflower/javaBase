package learn.basic.base;


/**
 * ��ļ���˳�� 1.���ྲ̬��Ա������ʼ�� 2.���ྲ̬����� 3.����Ǿ�̬��Ա������ʼ�� 4.���๹������ 5.���๹�캯�� 6.���๹������
 * 7.���๹�캯�� 8.���෽�� ע��������ิд�˸���ķ������ڸ����е��ø÷�����ʱ�򣬻��ǵ��õ�����ķ�����
 * 
 * @author pillow
 *
 */
class ParentClass {
	public static int a = 2;
	// public ParentClass pc = new ParentClass();
	public int b = 3;
	{
		System.out.println("this is anonymity b=" + b);
	}
	static {
		a = 4;
		System.out.println("this is static and a=" + a);
	}

	public ParentClass() {
		System.out.println("this is parent gozao");
		this.s();
	}

	public void s() {
		System.out.println("this is parent");
	}
}

public class Son extends ParentClass {
	static {
		System.out.println("son static");
	}
	{
		System.out.println("son constructor ");
	}

	public Son() {
		System.out.println("this is  son gozao");
	}

	public static void main(String[] args) {
		ParentClass d = new Son();
		d.s();
	}

	public void s() {
		// super.s();
		System.out.println("this is son");
	}
}
