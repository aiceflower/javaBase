package learn.frame.log4j;

import org.apache.log4j.Logger;

public class SysLog {

	static Logger hjfLogger = Logger.getLogger("hjf.info");
	
	
	public static final void info(String msg) {
		hjfLogger.info(msg);
	}
	
	public static final void error(String msg) {
		hjfLogger.error(msg);
	}

	public static void main(String[] args) {
		SysLog.info("我的第一个log4j日志");
		SysLog.error("第一个log4j错误");
		System.out.println("success");
	}
}
