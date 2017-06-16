package learn.design.pattern.singleton;


/**
 * ����ģʽ֮����ʽ��ʹ�õ�ʱ��Ŵ�������
 * �ص㣺
 * 1.���ص�ʱ��죬���е�ʱ����
 * 2.�̲߳���ȫ��
 * 3.����̲߳���ȫ����
 * @author hjf
 *
 */
public class Singleton2 {
	
	//[1]˽�л����췽��
	private Singleton2(){
		
	}
	
	//[2]����һ������
	private static  Singleton2 singleton ;
	
	//[3]�ṩ����ķ��ʷ�ʽ
	/**
	 * �ṩ����ķ��ʷ�ʽ
	 * ����˫���жϽ���̲߳���ȫ���⣬����Ч�ʱȽϵ�
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
