package learn.design.pattern.factory;

import java.util.Map;
import java.util.Properties;


/**
 * 发型工厂
 * @author Administrator
 *
 */
public class HairFactory {
	
	//根据类型判断，每来一种需要判断一次，不够智能
	/**
	 * 根据类型创建发型
	 * @param key
	 * @return
	 */
	public HairInterface getHair(String key){
		if("left".equals(key)){
			return new LeftHair();
		}else if("right".equals(key)){
			return new RightHair();
		}
		return null;
	}
	
	
	/**
	 * 根据类名来创建发型对象
	 * @param className
	 * @return
	 */
	public HairInterface getHairByClass(String className){
		try {
			HairInterface hair = (HairInterface) Class.forName(className).newInstance();
			return hair;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据类名对应的key来创建发型对象
	 * @param className
	 * @return
	 */
	public HairInterface getHairByClassKey(String key){
		
		try {
			Map<String, String> map = PropertiesReader.getProperties();
			String className = map.get(key);
			HairInterface hair = (HairInterface) Class.forName(className).newInstance();
			return hair;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
