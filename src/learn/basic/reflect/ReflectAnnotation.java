package learn.basic.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 反射注解�?要从作用目标上返�?
 * 
 * Class
 * 
 * Method,Constructor,Field：这三个是AccessibleObject的子�?
 * 
 * @author pillow
 *
 */
public class ReflectAnnotation {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		// ..........获取类上的注�?.................
		// 1.得到作用目标
		Class c = P.class;
		// 2.获取指定类型的注�?
		Anno a = (Anno) c.getAnnotation(Anno.class);
		System.out.println(a.name() + ".." + a.age() + ".." + a.sex());

		// ..............获取方法，构造器，属性上的注�?............................

		// 举例方法，其它类�?
		Method m = c.getMethod("method");
		a = m.getAnnotation(Anno.class);
		System.out.println(a.name() + ".." + a.age() + ".." + a.sex());
	}
}

@Anno(name = "张三", age = 18, sex = "man")
class P {
	@Anno(name = "李四", age = 17, sex = "woman")
	public void method() {

	}
}
@Retention(RetentionPolicy.RUNTIME)
@interface Anno {
	String name();

	int age();

	String sex();
}


