package learn.design.pattern.singleton;


/**
 * 单例模式之懒汉式（使用的时候才创建对像）
 * 特点：
 * 1.加载的时候快，运行的时候慢
 * 2.线程不安全的
 * 3.解决线程不安全问题
 * @author hjf
 *
 */
public class Singleton2 {
	
	//[1]私有化构造方法
	private Singleton2(){
		
	}
	
	//[2]创建一个对象
	private static  Singleton2 singleton ;
	
	//[3]提供对外的访问方式
	/**
	 * 提供对外的访问方式
	 * 利用双重判断解决线程不安全问题，但是效率比较低
	 * @return
	 */
	public static Singleton2 getInstance(){
		if(singleton==null){
			synchronized (Singleton2.class) {
				if(singleton==null)
					singleton = new Singleton2();
			}
		}
		return singleton;
	}
	
}
