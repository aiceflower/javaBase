package learn.design.pattern.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client {
	public static void main(String[] args) {
		//orgin();
		//byType("left");
		//byClass(LeftHair.class.getName());
		//getHairByClassKey("center");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		String format = sdf.format(now.getTime());
		now.set(Calendar.DATE, now.get(Calendar.DATE) - 2);
		String format1 = sdf.format(now.getTime());
		System.out.println("����"+format);
		System.out.println("����ǰ"+format1);
	}
	
	/**
	 * version 1.0(����ÿ��һ���µķ��;���Ҫ����һ���µ�Hair�࣬����Ҫ�ڿͻ��˵��ã�������������ά����Ҳ�����ڹ���)
	 *��ʹ�ù����������� 
	 */
	public static void orgin(){
		LeftHair l = new LeftHair();
		l.draw();
		RightHair r = new RightHair();
		r.draw();
	}
	
	/**
	 * version 2.0(���������жϣ�ÿ��һ��������Ҫ�ж�һ�Σ���������)
	 * ���͹���ͨ���������ʹ�������
	 * @param str
	 */
	public static void byType(String str){
		HairFactory factory = new HairFactory();
		HairInterface left = factory.getHair(str);
		left.draw();
	}
	
	/**
	 * version 3.0(����̫�����ܲ��ܼ��һ��)
	 * ���͹���ͨ�������������������
	 * @param className
	 */
	public static void byClass(String className){
		HairFactory factory = new HairFactory();
		HairInterface hair = factory.getHairByClass(className);
		hair.draw();
	}
	
	/**
	 * version 4.0
	 * ��ȡӳ���ļ�properties��������key����������
	 * @param key
	 */
	public static void getHairByClassKey(String key){
		HairFactory factory = new HairFactory();
		HairInterface hair = factory.getHairByClassKey(key);
		hair.draw();
	}
}
