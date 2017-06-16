package learn.basic.jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ����������ݿ����ӵ���
 */
public class DBUtil {
	// ���ӳ�
	private static BasicDataSource cp;
/*		private static String driverName;
	private static String url;
	private static String username;
	private static  String password;*/
	
	
	/*
	 * ��ȡһ�����ݿ������
	 */
	static{
		/*
		 * ��̬�������������һ�α����ص�ʱ��ִ�� ��ֻ��ִ��һ�������������ʼ����̬ ����������ʵĵط���
		 */
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			// �����������ʼ��
			String driverName=prop.getProperty("driverName");
			String url = prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			// ���������
			int maxActive = Integer.parseInt(prop.getProperty("maxActive"));
			// ���ȴ�ʱ��
			int maxWait = Integer.parseInt(prop.getProperty("maxWait"));
		/*	System.out.println(driverName);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(maxActive);
			System.out.println(maxWait);*/
			
			// ��ʼ�����ӳ�
			cp = new BasicDataSource();
			// �൱����Class.forName()�е�����
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
		 * System.out.println("���ӳɹ���"); return cnn;
		 */
		/*
		 * �����ӳ�Ҫһ�����õĿ������� �����ӳ����п������ӣ���ֱ�ӷ��� ��û�У���÷�����������״̬���ȴ���������
		 * �ȴ���ʱ���ɳ�ʼ�����ӳ�ʱ���õ�maxWait ��ʱ��һ�¡��� �ȴ�ʱ���ڳ��ֿ��ÿ������� ��÷��������̷��ظ����ӣ����ȴ�ʱ�䳬��
		 * ����Ȼû�п������ӣ��÷������׳���ʱ�쳣��
		 */
		return cp.getConnection();
	}
	
	// �����������ݿ����ӹر�
	public static void closeConnection(Connection conn){
		try{
			if(conn!=null)
				// �������൱�ڰ����ӻ������ӳز�û����Ĺر�
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
