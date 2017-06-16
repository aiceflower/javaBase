package learn.basic.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;

import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;

/**
 * java���ô洢����
 * 
 * @author pillow
 *
 */
public class TestFunction {
	/*
	 * һ���洢������ͷ��
	 * 
	 * create or replace function queryemp(eno in number)
	 */
	@Test
	public void testFunction() {
		// {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
		String sql = "?=call queryemp(?)";
		Connection conn = null;
		CallableStatement call = null;
		try {
			// �õ�һ������
			conn = JDBCUtils.getConnection();
			// ͨ�����Ӵ�����statement
			call = conn.prepareCall(sql);
			// ����out����������
			call.registerOutParameter(1, OracleTypes.NUMBER);
			// ����in��������ֵ
			call.setInt(2, 7839);
			// ִ�е���
			call.execute();
			// ȡ�����
			double income = call.getDouble(1);
			System.out.println("��Ա������������" + income);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// �ͷ���Դ
			JDBCUtils.release(conn, call, null);
		}
	}
}
