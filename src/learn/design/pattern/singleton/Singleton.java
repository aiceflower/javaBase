package learn.design.pattern.singleton;


/**
 * ����ģʽ֮����ʽ���������ʱ��ʹ�������
 * �ص㣺
 * 1.���ص�ʱ���������е�ʱ���
 * 2.�̰߳�ȫ��
 * @author hjf
 *
 */
public class Singleton {
	
	//[1]˽�л����췽��
	private Singleton(){
		
	}
	
	//[2]����һ������
	private static  Singleton singleton = new Singleton();
	
	//[3]�ṩ����ķ��ʷ�ʽ
	/**
	 * �ṩ����ķ��ʷ�ʽ
	 * @return
	 */
	public static Singleton getInstance(){
		return singleton;
	}
	
}
