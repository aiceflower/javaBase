package learn.basic.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;

/**
 * java���ô洢����
 * 
 * @author pillow
 *
 */
public class TestProcedure {
	/*
	 * һ���洢���̵�ͷ�� create or replace procedure queryempinform( eno in number,
	 * pename out varchar2, psal out number, pjob out varchar2)
	 */

	@Test
	public void testProcedurt() {
		// {call <procedure-name>[(<arg1>,<arg2>, ...)]}
		String sql = "call queryempinform(?,?,?,?)";
		Connection conn = null;
		CallableStatement call = null;
		try {
			// �õ�һ������
			conn = JDBCUtils.getConnection();
			// ͨ�����Ӵ�����statement
			call = conn.prepareCall(sql);
			// ����in��������ֵ
			call.setInt(1, 7839);
			// ����out����������
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			call.registerOutParameter(3, OracleTypes.NUMBER);
			call.registerOutParameter(4, OracleTypes.VARCHAR);
			// ִ�е���
			call.execute();
			// ȡ�����
			String name = call.getString(2);
			double sal = call.getDouble(3);
			String job = call.getString(4);

			System.out.println(name + "," + sal + "," + job);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			JDBCUtils.release(conn, call, null);
		}
	}
}
