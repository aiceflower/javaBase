package learn.practice;

public class Init {

	static{
		/*
		 * 虚拟机会保证一个类的＜clinit＞（）方法在多线程环境中被正确地加锁、同步，如果多
			个线程同时去初始化一个类，那么只会有一个线程去执行这个类的＜clinit＞（）方法，其他
			线程都需要阻塞等待，直到活动线程执行＜clinit＞（）方法完毕。
		 */
		if(true){//如果不加这个判断下面的代码无法通过编译
			System.out.println(Thread.currentThread()+"init DeadLoopClass");
			while(true){
			
			}
		}
		i = 0;
		//System.out.println(i);编译报错
		//非法向前引用变量
		/*编译器收集的顺序是由语句在源文件中出现的顺序所决
		定的，静态语句块中只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前
		面的静态语句块可以赋值，但是不能访问
		*/
	}
	{
		b = "hello";
		//System.out.println(b);同理
	}
	private String b = "a";
	public static int i = 1;
	public static void main(String[] args) {
		System.out.println(i);
		Init in = new Init();
		System.out.println(in.b);
	}
}
