package learn.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassUtil {
	public static void main(String [] args){
		printClassMessage(String.class);
	}
	
	/**
	 * 打印类的所有信息
	 * @param c
	 */
	public static void printClassMessage(Class c){
		//获取类的信息，先获取类类型
		printClass(c);
		printMethods(c);
		printDeclaredMethods(c);
		printFields(c);
		printDeclaredFields(c);
		printConstructors(c);
		printDeclaredConstructor(c);
	}

	/**
	 * 打印类的信息
	 * @param c
	 */
	private static void printClass(Class c) {
		System.out.println("打印类信息--------start----------------------");
		//获取类的修饰符
		String modifier = Modifier.toString(c.getModifiers());
		System.out.print(modifier+" ");
		//获取类的名称
		System.out.println(c.getName());
		System.out.println();
	}

	/**
	 * 打印方法信息，包括父类（public权限）
	 * @param c
	 */
	private static void printMethods(Class c) {
		//获取方法
		System.out.println("所有public修饰的方法--------start----------------------");
		Method[] ms = c.getMethods();//获取的是所有的public的函数，包括父类继承而来的
		for (Method method : ms) {
			//得到方法的修饰符
			String modifier = Modifier.toString(method.getModifiers());
			System.out.print(modifier+" ");
			//得到方法的返回值类型的类类型
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+" ");
			//得到方法的名称
			String methodName = method.getName();
			System.out.print(methodName+"(");
			//获取参数类型-->得到的是参数列表的类型的类类型
			Class[] parameterTypes = method.getParameterTypes();
			for (int i = 0;i<parameterTypes.length;++i) {
				if(i==parameterTypes.length-1){
					System.out.print(parameterTypes[i].getName());
				}else{
					System.out.print(parameterTypes[i].getName()+",");
				}
			}
			System.out.println(")");
		}
		System.out.println("所有public修饰的方法--------end----------------------");
		System.out.println();
	}

	/**
	 * 打印方法信息信息，该类自己声明的(所有权限)
	 * @param c
	 */
	private static void printDeclaredMethods(Class c) {
		System.out.println("自己声明的方法--------start----------------------");
		Method[] sms = c.getDeclaredMethods();//获取的是所有该类自己 声明的方法，不问访问权限
		for (Method method : sms) {
			//得到方法的返回值类型的类类型
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+" ");
			//得到方法的名称
			String methodName = method.getName();
			System.out.print(methodName+"(");
			//获取参数类型-->得到的是参数列表的类型的类类型
			Class[] parameterTypes = method.getParameterTypes();
			for (int i = 0;i<parameterTypes.length;++i) {
				if(i==parameterTypes.length-1){
					System.out.print(parameterTypes[i].getName());
				}else{
					System.out.print(parameterTypes[i].getName()+",");
				}
			}
			System.out.println(")");
		}
		System.out.println("自己声明的方法--------end----------------------");
		System.out.println();
	}

	/**
	 * 打印成员变量信息，包括父类（public权限）
	 * @param c
	 */
	private static void printFields(Class c) {
		/*
		 * 成员变量也是对象java.lang.reflect.Field
		 * Field封装了关于成员变量的信息
		 * getField()获取的是所有的public的成员变量的信息
		 * getDeclaredField()获取的是该类自己的声明
		 */
		System.out.println("所有public修饰的成员变量--------start----------------------");
		Field[] fields = c.getFields();
		for (Field field : fields) {
			//得到成员变量的类型的类类型
			Class type = field.getType();
			System.out.print(type+" ");
			System.out.println(field.getName());
		}
		System.out.println("所有public修饰的成员变量--------end----------------------");
		System.out.println();
	}

	/**
	 * 打印成员变量信息，该类自己声明的(所有权限)
	 * @param c
	 */
	private static void printDeclaredFields(Class c) {
		System.out.println("自己声明的成员变量--------start----------------------");
		Field[] sfields = c.getDeclaredFields();
		for (Field field : sfields) {
			//得到成员变量的类型的类类型
			String modifier = Modifier.toString(field.getModifiers());
			System.out.print(modifier+" ");
			Class type = field.getType();
			System.out.print(type+" ");
			System.out.println(field.getName());
		}
		System.out.println("自己声明的成员变量--------end----------------------");
		System.out.println();
	}

	/**
	 * 打印构造方法信息，包括父类的（public权限）
	 * @param c
	 */
	private static void printConstructors(Class c) {
		//构造函数
		Constructor[] constructors = c.getConstructors();
		System.out.println("所有public修饰的构造方法------------------start-------------------------------");
		for (Constructor constructor : constructors) {
			//获取修饰符
			String modifier = Modifier.toString(constructor.getModifiers());
			System.out.print(modifier+" ");
			//获取构造方法名
			String constructorName = constructor.getName();
			System.out.print(constructorName+"(");
			Class[] parameters = constructor.getParameterTypes();
			for(int i = 0;i<parameters.length;++i){
				System.out.print(parameters[i].getName());
			}
			System.out.println(")");
		}
		System.out.println("所有public修饰的构造方法------------------end-------------------------------");
		System.out.println();
	}
	
	public static void printDeclaredConstructor(Class c){
		//构造函数
		Constructor[] constructors = c.getDeclaredConstructors();
		System.out.println("自己声明的构造方法------------------start-------------------------------");
		for (Constructor constructor : constructors) {
			//获取修饰符
			String modifier = Modifier.toString(constructor.getModifiers());
			System.out.print(modifier+" ");
			//获取构造方法名
			String constructorName = constructor.getName();
			System.out.print(constructorName+"(");
			Class[] parameters = constructor.getParameterTypes();
			for(int i = 0;i<parameters.length;++i){
				System.out.print(parameters[i].getName());
			}
			System.out.println(")");
		}
		System.out.println("自己声明的构造方法------------------end-------------------------------");
		System.out.println();
	}
}
