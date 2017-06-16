package learn.design.pattern.factory;

import java.util.Map;
import java.util.Properties;


/**
 * ���͹���
 * @author Administrator
 *
 */
public class HairFactory {
	
	//���������жϣ�ÿ��һ����Ҫ�ж�һ�Σ���������
	/**
	 * �������ʹ�������
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
	 * �����������������Ͷ���
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
	 * ����������Ӧ��key���������Ͷ���
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
