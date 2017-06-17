package learn.basic.plsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private static String driver = "";
	private static String url = "";
	@SuppressWarnings("unused")
	private static String user = "";
	@SuppressWarnings("unused")
	private static String password = "";

	// ע�����ݿ������
	static {
		try {
			Class.forName(driver);
			// DriverManager.registerDriver(driver);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

	// ��ȡ���ݿ�����
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// �ͷ����ݿ���Դ
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				st = null;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
