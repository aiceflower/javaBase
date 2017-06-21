package learn.basic.exception;


public class ExceptionUtil {
	public static void main(String[] args) {
		getStackTrace();
	}
	
	/**
	 * 获取堆栈信息
	 * @return
	 */
	public static StackTraceElement[] getStackTrace(){
		//String fullStackTrace = org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e);
		return Thread.currentThread().getStackTrace();
	}
}
