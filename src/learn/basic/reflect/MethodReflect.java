package learn.basic.reflect;

import java.lang.reflect.Method;

public class MethodReflect {
	public static void main(String[] args){
		//��ȡ����print(int,int)
		//Ҫ��ȡ����������Ҫ��ȡ�����Ϣ����ȡ�����Ϣ��Ҫ��ȡ���������
		A a1 = new A();
		Class a = a1.getClass();
		try {
			//��ʽһ��ȡ
			Method method1 = a.getMethod("print", new Class []{int.class,int.class});
			//��ʽ����ȡ
			Method method2 = a.getMethod("print", int.class,int.class);
			//�����ķ������,�����a1Ϊ��Ҫ����Ķ���
			method1.invoke(a1,new Object[]{1,2});//������
			//���ص��Ƿ����ķ���ֵ���������ֵΪvoid��Ϊnull
			Object invoke = method2.invoke(a1, 1,2);//�м�����������������
			System.out.println(invoke);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			Method method = a.getMethod("print", new Class[]{String.class,String.class});
			method.invoke(a1, "hello","World");
		} catch (Exception e) {
			System.err.println("�÷���������");
		}
	}
}
