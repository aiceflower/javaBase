package learn.basic.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectGenericity {
	public static void main(String[] args) {
		new C();
	}
}

class A<T> {
	/**
	 * 反射泛型信息
	 */
	@SuppressWarnings("rawtypes")
	public A() {
		// 在这里获取子类传递的泛型信息，要得到�?个Class!
		Class class1 = this.getClass();
		System.out.println(class1);
		Type type = class1.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		Class c = (Class) types[0];
		System.out.println(c.getName());
		// 以下代替上面�?�?
		System.out
				.println(((Class) ((ParameterizedType) this.getClass()
						.getGenericSuperclass()).getActualTypeArguments()[0])
						.getName());
	}
}

class B extends A<String> {

}

class C extends A<Integer> {

}