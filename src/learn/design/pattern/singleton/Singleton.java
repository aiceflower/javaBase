package learn.design.pattern.singleton;


/**
 * 单例模式之饿汉式（加载类的时候就创建对像）
 * 特点：
 * 1.加载的时候慢，运行的时候快
 * 2.线程安全的
 * @author hjf
 *
 */
public class Singleton {
	
	//[1]私有化构造方法
	private Singleton(){
		
	}
	
	//[2]创建一个对象
	private static  Singleton singleton = new Singleton();
	
	//[3]提供对外的访问方式
	/**
	 * 提供对外的访问方式
	 * @return
	 */
	public static Singleton getInstance(){
		return singleton;
	}
	
}
