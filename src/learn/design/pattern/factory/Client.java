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
		System.out.println("今天"+format);
		System.out.println("两天前"+format1);
	}
	
	/**
	 * version 1.0(这样每来一个新的发型就需要创建一个新的Hair类，而需要在客户端调用，这样即不利于维护，也不利于管理)
	 *不使用工厂创建发型 
	 */
	public static void orgin(){
		LeftHair l = new LeftHair();
		l.draw();
		RightHair r = new RightHair();
		r.draw();
	}
	
	/**
	 * version 2.0(根据类型判断，每来一种类型需要判断一次，不够智能)
	 * 发型工厂通过传入类型创建发型
	 * @param str
	 */
	public static void byType(String str){
		HairFactory factory = new HairFactory();
		HairInterface left = factory.getHair(str);
		left.draw();
	}
	
	/**
	 * version 3.0(类名太长，能不能简短一点)
	 * 发型工厂通过传入的类名创建发型
	 * @param className
	 */
	public static void byClass(String className){
		HairFactory factory = new HairFactory();
		HairInterface hair = factory.getHairByClass(className);
		hair.draw();
	}
	
	/**
	 * version 4.0
	 * 读取映射文件properties，根据其key，创建发型
	 * @param key
	 */
	public static void getHairByClassKey(String key){
		HairFactory factory = new HairFactory();
		HairInterface hair = factory.getHairByClassKey(key);
		hair.draw();
	}
}
