package learn.basic.exception;


public class ExceptionUtil {
	public static void main(String[] args) {
		getStackTrace();
	}
	
	/**
	 * ��ȡ��ջ��Ϣ
	 * @return
	 */
	public static StackTraceElement[] getStackTrace(){
		//String fullStackTrace = org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e);
		return Thread.currentThread().getStackTrace();
	}
}
