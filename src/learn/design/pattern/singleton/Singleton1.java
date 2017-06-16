package learn.design.pattern.singleton;


/**
 * ����ģʽ֮����ʽ��ʹ�õ�ʱ��Ŵ�������
 * �ص㣺
 * 1.���ص�ʱ��죬���е�ʱ����
 * 2.�̲߳���ȫ��
 * @author hjf
 *
 */
public class Singleton1 {
	
	//[1]˽�л����췽��
	private Singleton1(){
		
	}
	
	//[2]����һ������
	private static  Singleton1 singleton ;
	
	//[3]�ṩ����ķ��ʷ�ʽ
	/**
	 * �ṩ����ķ��ʷ�ʽ
	 * @return
	 */
	public static Singleton1 getInstance(){
		if(singleton==null){
			singleton = new Singleton1();
		}
		return singleton;
	}
	
}
