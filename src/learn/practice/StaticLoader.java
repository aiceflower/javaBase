package learn.practice;

public class StaticLoader {

	/*
	 * 被动使用类字段
	 */
	public static void main(String[] args) {
		//1.通过子类引用父类的静态字段，不会导致子类初始化
		System.out.println(SubClass.value);
		//对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静
		//态字段，只会触发父类的初始化而不会触发子类的初始化。
		//2.通过数组定义来引用类，不会触发此类的初始化
		SuperClass [] scs = new SuperClass[5];
		System.out.println(scs);
		//这段代码里面触发了另外一个类的初始化它是一个由虚拟机自动生成的、直
		//接继承于java.lang.Object的子类，创建动作由字节码指令newarray触发。
		//3常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
		System.out.println(ConstClass.HELLOWORLD);//如果不是常量(非final)则会初始化类
		//在编译阶段通过常量传播优化，已经将此常量
		//的值“hello  world”存储到了NotInitialization类的常量池中，
	}
}
class SuperClass{
	static{
		System.out.println("SuperClass init");
	}
	
	public static int value = 3;
}
class SubClass extends SuperClass{
	static{
		System.out.println("SubClass init");
	}
}
class ConstClass{
	static{
		System.out.println("ConstClass init！");
	}
	public static final String HELLOWORLD="hello world";
}
