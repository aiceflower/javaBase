package learn.basic.base;


/**
 * 类的加载顺序 1.父类静态成员变量初始化 2.父类静态代码块 3.父类非静态成员变量初始化 4.父类构造代码块 5.父类构造函数 6.子类构造代码块
 * 7.子类构造函数 8.子类方法 注：如果子类复写了父类的方法，在父类中调用该方法的时候，还是调用的子类的方法。
 * 
 * @author pillow
 *
 */
class ParentClass {
	public static int a = 2;
	// public ParentClass pc = new ParentClass();
	public int b = 3;
	{
		System.out.println("this is anonymity b=" + b);
	}
	static {
		a = 4;
		System.out.println("this is static and a=" + a);
	}

	public ParentClass() {
		System.out.println("this is parent gozao");
		this.s();
	}

	public void s() {
		System.out.println("this is parent");
	}
}

public class Son extends ParentClass {
	static {
		System.out.println("son static");
	}
	{
		System.out.println("son constructor ");
	}

	public Son() {
		System.out.println("this is  son gozao");
	}

	public static void main(String[] args) {
		ParentClass d = new Son();
		d.s();
	}

	public void s() {
		// super.s();
		System.out.println("this is son");
	}
}
