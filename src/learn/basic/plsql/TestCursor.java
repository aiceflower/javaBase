package learn.basic.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleCallableStatement;
import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;

/**
 * java���ð��µĴ洢���̣�ʵ���ǵ��ô洢����
 * 
 * ��ѯĳ������������Ա����������Ϣ
 * 
 * ������out
 * 
 * @author pillow
 *
 */
public class TestCursor {
	/*
	 * CREATE OR REPLACE PACKAGE MYPACKAGE AS type empcursor is ref cursor;
	 * 
	 * procedure queryEmpList(dno in number, empList out empcursor);
	 * 
	 * END MYPACKAGE;
	 */
	@Test
	public void testCursor() {
		// {call <procedure-name>[(<arg1>,<arg2>, ...)]}
		String sql = "call MYPACKAGE.queryEmpList(?,?)";
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			// �õ�һ������
			conn = JDBCUtils.getConnection();
			// ͨ�����Ӵ�����statement
			call = conn.prepareCall(sql);
			// ����out����������
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// ����in��������ֵ
			call.setInt(1, 10);
			// ִ�е���
			call.execute();
			// ȡ�����
			rs = ((OracleCallableStatement) call).getCursor(2);

			while (rs.next()) {
				// ȡ����Ա����Ա���ţ�������ְλ
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("empjob");
				System.out.println(empno + "," + name + "," + job);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			JDBCUtils.release(conn, call, rs);
		}
	}
}
