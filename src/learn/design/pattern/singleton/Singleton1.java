package learn.design.pattern.singleton;


/**
 * 单例模式之懒汉式（使用的时候才创建对像）
 * 特点：
 * 1.加载的时候快，运行的时候慢
 * 2.线程不安全的
 * @author hjf
 *
 */
public class Singleton1 {
	
	//[1]私有化构造方法
	private Singleton1(){
		
	}
	
	//[2]创建一个对象
	private static  Singleton1 singleton ;
	
	//[3]提供对外的访问方式
	/**
	 * 提供对外的访问方式
	 * @return
	 */
	public static Singleton1 getInstance(){
		if(singleton==null){
			singleton = new Singleton1();
		}
		return singleton;
	}
	
}
