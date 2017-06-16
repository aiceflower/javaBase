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
		SysLog.info("�ҵĵ�һ��log4j��־");
		SysLog.error("��һ��log4j����");
		System.out.println("success");
	}
}
