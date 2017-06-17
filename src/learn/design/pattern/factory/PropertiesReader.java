package learn.design.pattern.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * properties文件的读取工具
 * @author Administrator
 *
 */
public class PropertiesReader {
	
	@SuppressWarnings("unused")
	public static Map<String, String> getProperties(){
		Properties properties = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			String str = System.getProperty("user.dir");
			str +=
				File.separator+"src"
			    +File.separator+"learn"
				+File.separator+"design"
				+File.separator+"pattern"
				+File.separator+"factory"
				+File.separator+"hairtype.properties";
			//System.out.println(str);
			//properties.load(new FileInputStream(str));
			//获取文件方式一(上)---------------------------------------------
			//获取文件方式二(下)---------------------------------------------
			//静太方法加载
			InputStream stream = PropertiesReader.class.getResourceAsStream("hairtype.properties");
			//非静态方法加载
			//InputStream stream1 = getClass().getResourceAsStream("hairtype.properties");
			
			properties.load(stream);
			
			Enumeration<?> names = properties.propertyNames();
			while(names.hasMoreElements()){
				String key = (String)names.nextElement();
				map.put(key, properties.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			System.out.println("未找到文件");
		} catch (IOException e) {
			System.out.println("流异常");
		}
		return map;
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		PropertiesReader pr = new PropertiesReader();
		Map<String, String> properties = pr.getProperties();
		System.out.println(properties);
	}
}
