package learn.basic.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleCallableStatement;
import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;

/**
 * java调用包下的存储过程，实际是调用存储过程
 * 
 * 查询某个部门中所有员工的所有信息
 * 
 * 带光标的out
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
			// 得到一个连接
			conn = JDBCUtils.getConnection();
			// 通过连接创建出statement
			call = conn.prepareCall(sql);
			// 对于out参数，申明
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 对于in参数，赋值
			call.setInt(1, 10);
			// 执行调用
			call.execute();
			// 取出结果
			rs = ((OracleCallableStatement) call).getCursor(2);

			while (rs.next()) {
				// 取出该员工的员工号，姓名，职位
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("empjob");
				System.out.println(empno + "," + name + "," + job);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			JDBCUtils.release(conn, call, rs);
		}
	}
}
