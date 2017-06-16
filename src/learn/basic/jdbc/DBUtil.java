package learn.basic.jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 负责管理数据库连接的类
 */
public class DBUtil {
	// 连接池
	private static BasicDataSource cp;
/*		private static String driverName;
	private static String url;
	private static String username;
	private static  String password;*/
	
	
	/*
	 * 获取一个数据库的连接
	 */
	static{
		/*
		 * 静态块由于是在类第一次被加载的时候执行 且只会执行一次所以在这里初始化静态 属性是最合适的地方。
		 */
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			// 根据配置项初始化
			String driverName=prop.getProperty("driverName");
			String url = prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			// 最大连接数
			int maxActive = Integer.parseInt(prop.getProperty("maxActive"));
			// 最大等待时间
			int maxWait = Integer.parseInt(prop.getProperty("maxWait"));
		/*	System.out.println(driverName);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(maxActive);
			System.out.println(maxWait);*/
			
			// 初始化连接池
			cp = new BasicDataSource();
			// 相当于是Class.forName()中的内容
			cp.setDriverClassName(driverName);
			cp.setUrl(url);
			cp.setUsername(username);
			cp.setPassword(password);
			cp.setMaxActive(maxActive);
			cp.setMaxWait(maxWait);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
	
		/*
		 * Class.forName(driverName); Connection cnn =
		 * DriverManager.getConnection(url,username,password);
		 * System.out.println("连接成功！"); return cnn;
		 */
		/*
		 * 向连接池要一条可用的空闲连接 若连接池尚有可用连接，会直接返回 若没有，则该方法进入阻塞状态，等待可用连接
		 * 等待的时间由初始化连接池时设置的maxWait 的时间一致。若 等待时间内出现可用空闲连接 则该方法会立刻返回该连接，若等待时间超过
		 * 后仍然没有可用连接，该方法会抛出超时异常。
		 */
		return cp.getConnection();
	}
	
	// 将给定的数据库连接关闭
	public static void closeConnection(Connection conn){
		try{
			if(conn!=null)
				// 在这里相当于把连接还给连接池并没有真的关闭
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
