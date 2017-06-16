package learn.frame.log4j;

import java.io.InputStream;
import java.util.Properties;

public class SysProp {
	private static String config = "jdbc.properties";
	private static Properties properties = null;
	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		SysProp.config = config;
	}

	public void readConfig(String config){
		InputStream in = null;
		properties = new Properties();
		try {
			in = getClass().getClassLoader().getResourceAsStream(config);
			properties.load(in);
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		SysProp prop = new SysProp();
		prop.readConfig(config);
		String string = properties.getProperty("jdbc.username");
		System.out.println(string);
	}
}
