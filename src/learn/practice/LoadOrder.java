package learn.practice;

public class LoadOrder {
	{
		weight = 2.1;
		System.out.println("���Ǵ����");
	}
	double weight = 2.0;
	static {
		heigth = 3.1;
		System.out.println("���Ǿ�̬�����");
	}
	
	static double heigth = 3.0;

	public static void main(String[] args) {
		B.main(args); //����ֻ���۳�Ա����
		//��̬�����ִֻ��һ�Σ��������ÿ����һ��ʵ�����ͻ�ִ��һ�Ρ�
		LoadOrder j1 = new LoadOrder();
		LoadOrder j2 = new LoadOrder();
		System.out.println(j1.weight);//���������ʱ���ȳ�ʼ����Ȼ����ִ�д�����еĸ�ֵ�����ڹ������и�ֵ
		//���Ƕ�������������ִ��˳������д˳��һ�£�����
		//������������ͨ������֮����ִ�е�ʱ�򶼻ᰴ˳���ᵽ��������ִ��
		//		double weight;
		//		public ����˳��(){
		//		  weight = 2.1;
		//		System.out.println("���Ǵ����");
		//		  weight = 2.0;
		//		}
		System.out.println(LoadOrder.heigth);//ԭ��ͬ��
		//����˳��
		//���ྲ̬�����-->���ྲ̬�����-->��������-->���๹�췽��-->��������-->���๹�췽��
		System.out.println(j2.weight);
	}
}

class A{
	
	{
		System.out.println("A�Ĺ�������1");
	}
	public A(){
		System.out.println("A�Ĺ�����");
	}
	{
		System.out.println("A�Ĺ�������");
	}
	static{
		System.out.println("A�ľ�̬�����");
	}
}

class B extends A{
	@SuppressWarnings("unused")
	private static int c = 1;
	static{
		System.out.println("B�ľ�̬�����");
		c = 2;
	}
	public B(){
		System.out.println("B�Ĺ�����");
	}
	{
		System.out.println("B�Ĺ�������");
		age = 2;
	}
	int age = 1;
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.age);
	}
}
