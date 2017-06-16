package learn.basic.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;

/**
 * java调用存储过程
 * 
 * @author pillow
 *
 */
public class TestProcedure {
	/*
	 * 一个存储过程的头部 create or replace procedure queryempinform( eno in number,
	 * pename out varchar2, psal out number, pjob out varchar2)
	 */

	@Test
	public void testProcedurt() {
		// {call <procedure-name>[(<arg1>,<arg2>, ...)]}
		String sql = "call queryempinform(?,?,?,?)";
		Connection conn = null;
		CallableStatement call = null;
		try {
			// 得到一个连接
			conn = JDBCUtils.getConnection();
			// 通过连接创建出statement
			call = conn.prepareCall(sql);
			// 对于in参数，赋值
			call.setInt(1, 7839);
			// 对于out参数，申明
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			call.registerOutParameter(3, OracleTypes.NUMBER);
			call.registerOutParameter(4, OracleTypes.VARCHAR);
			// 执行调用
			call.execute();
			// 取出结果
			String name = call.getString(2);
			double sal = call.getDouble(3);
			String job = call.getString(4);

			System.out.println(name + "," + sal + "," + job);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放资源
			JDBCUtils.release(conn, call, null);
		}
	}
}
