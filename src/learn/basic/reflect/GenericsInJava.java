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
		
		//list.add(20);报错
		
		Class c1 = list.getClass();
		Class c2 = al.getClass();
		System.out.println(c1==c2);//true,更加说明了一个类只可能是Class类的一个实例对象
		//可通过方法的反射绕过编译
		try {
			Method method = c1.getMethod("add", Object.class);
			method.invoke(list, 20);//这样就可以添加了
			System.out.println(list);
			//用反射添加元素后就不能再使用for each来遍历了，会报类型转换异常
			for (String string : list) {
				System.out.println(string);//这里会抛异常
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
