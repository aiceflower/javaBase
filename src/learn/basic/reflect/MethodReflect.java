package learn.basic.reflect;

import java.lang.reflect.Method;

public class MethodReflect {
	public static void main(String[] args){
		//获取方法print(int,int)
		//要获取方法，就是要获取类的信息，获取类的信息就要获取类的类类型
		A a1 = new A();
		Class a = a1.getClass();
		try {
			//方式一获取
			Method method1 = a.getMethod("print", new Class []{int.class,int.class});
			//方式二获取
			Method method2 = a.getMethod("print", int.class,int.class);
			//方法的反射操作,这里的a1为需要反射的对象
			method1.invoke(a1,new Object[]{1,2});//传数组
			//返回的是方法的返回值，如果返回值为void则为null
			Object invoke = method2.invoke(a1, 1,2);//有几个参数传几个参数
			System.out.println(invoke);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			Method method = a.getMethod("print", new Class[]{String.class,String.class});
			method.invoke(a1, "hello","World");
		} catch (Exception e) {
			System.err.println("该方法不存在");
		}
	}
}
