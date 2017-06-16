package learn.frame.spring.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyPlaceholder extends PropertyPlaceholderConfigurer{
	private static  Map<String,String> propertyMap;
	private  Properties properties ;
	@Override
	protected void processProperties(ConfigurableListableBeanFactory factory,
			Properties properties) throws BeansException {
		super.processProperties(factory, properties);
		this.properties = properties;
		propertyMap = new HashMap<String, String>();
		for (Object key:properties.keySet()) {
			String keyStr = key.toString();
			String value = properties.getProperty(keyStr);
			propertyMap.put(keyStr, value);
		}
		
	}
	
	/**
	 * 获取properties文件
	 * @return
	 */
	public Properties getProperties(){
		return properties;
	}
	
	/**
	 * 获取key值
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T getPropert(String name){
		return (T) propertyMap.get(name);
	}
}
