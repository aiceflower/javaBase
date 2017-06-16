package learn.basic.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;

import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;

/**
 * java调用存储函数
 * 
 * @author pillow
 *
 */
public class TestFunction {
	/*
	 * 一个存储函数的头部
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
			// 得到一个连接
			conn = JDBCUtils.getConnection();
			// 通过连接创建出statement
			call = conn.prepareCall(sql);
			// 对于out参数，申明
			call.registerOutParameter(1, OracleTypes.NUMBER);
			// 对于in参数，赋值
			call.setInt(2, 7839);
			// 执行调用
			call.execute();
			// 取出结果
			double income = call.getDouble(1);
			System.out.println("该员工的年收入是" + income);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 释放资源
			JDBCUtils.release(conn, call, null);
		}
	}
}
