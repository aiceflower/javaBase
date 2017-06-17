package learn.basic.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GenericsInJava {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		
		//list.add(20);����
		
		Class c1 = list.getClass();
		Class c2 = al.getClass();
		System.out.println(c1==c2);//true,����˵����һ����ֻ������Class���һ��ʵ������
		//��ͨ�������ķ����ƹ�����
		try {
			Method method = c1.getMethod("add", Object.class);
			method.invoke(list, 20);//�����Ϳ��������
			System.out.println(list);
			//�÷������Ԫ�غ�Ͳ�����ʹ��for each�������ˣ��ᱨ����ת���쳣
			for (String string : list) {
				System.out.println(string);//��������쳣
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
