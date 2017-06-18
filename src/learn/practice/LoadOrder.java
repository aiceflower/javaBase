package learn.practice;

public class LoadOrder {
	{
		weight = 2.1;
		System.out.println("我是代码块");
	}
	double weight = 2.0;
	static {
		heigth = 3.1;
		System.out.println("我是静态代码块");
	}
	
	static double heigth = 3.0;

	public static void main(String[] args) {
		B.main(args); //这里只讨论成员变量
		//静态代码块只执行一次，而代码块每创建一个实例，就会执行一次。
		LoadOrder j1 = new LoadOrder();
		LoadOrder j2 = new LoadOrder();
		System.out.println(j1.weight);//定义变量的时候先初始化，然后再执行代码块中的赋值，再在构造器中赋值
		//但是定义变量与代码块的执行顺序与书写顺序一致！！！
		//定义与代码块在通过编译之后，在执行的时候都会按顺序提到构造器中执行
		//		double weight;
		//		public 加载顺序(){
		//		  weight = 2.1;
		//		System.out.println("我是代码块");
		//		  weight = 2.0;
		//		}
		System.out.println(LoadOrder.heigth);//原理同上
		//加载顺序
		//父类静态代码块-->子类静态代码块-->父类代码块-->父类构造方法-->子类代码块-->子类构造方法
		System.out.println(j2.weight);
	}
}

class A{
	
	{
		System.out.println("A的构造代码块1");
	}
	public A(){
		System.out.println("A的构造器");
	}
	{
		System.out.println("A的构造代码块");
	}
	static{
		System.out.println("A的静态代码块");
	}
}

class B extends A{
	@SuppressWarnings("unused")
	private static int c = 1;
	static{
		System.out.println("B的静态代码块");
		c = 2;
	}
	public B(){
		System.out.println("B的构造器");
	}
	{
		System.out.println("B的构造代码块");
		age = 2;
	}
	int age = 1;
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.age);
	}
}
