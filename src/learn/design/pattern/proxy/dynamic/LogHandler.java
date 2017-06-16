package learn.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object target;
	
	public LogHandler(Object target){
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("开始记录日志.......");
		method.invoke(target);
		System.out.println("记录日志结束.......");
		return null;
	}

}
