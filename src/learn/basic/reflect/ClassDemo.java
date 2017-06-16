package learn.basic.reflect;

public class ClassDemo {
	public static void main(String args[]){
		//Foo��ʵ��������α�ʾ
		Foo foo = new Foo();//foo�ͱ�ʾ������
		//����Foo�౾��Ҳ��һ������Class���ʵ��������α�ʾ�أ�
		//�κ�һ���඼��Class��ʵ�����������ֱ�ʾ��ʽ
		//[1]��ʾһ--->ʵ�ʸ������ǣ��κ�һ���࣬����һ�������ľ�̬��Ա����class
		Class c1 = Foo.class;
		//[2]��ʾ��--->�Ѿ�֪������Ķ���ͨ��getClass()����
		Class c2 = foo.getClass();
		//�������� c1,c2��ʾ��Foo���������(class type)
		//[3]��ʾ����
		Class c3 = null;
		try {
			 c3= Class.forName("learn.basic.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c1.getSimpleName());
		System.out.println(c2.getName());
		System.out.println(c1==c2?c2==c3?"c1����c2����c3":"c1����c2������c3":"c1������c26");
		try {
			Foo f1 = (Foo)c1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
class Foo{}
