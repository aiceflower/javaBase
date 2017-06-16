package learn.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	
	private Object target;
	
	public TimeHandler(Object target){
		super();
		this.target = target;
	}

	/**
	 * 时间代理
	 * 参数：
	 * proxy 被代理的对象
	 * method 被代理的方法
	 * args 方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶.......");
		method.invoke(target);
		long endTime = System.currentTimeMillis();
		System.out.println("汽车行驶结束，车子总共行驶了："+(endTime-startTime)+"毫秒");
		return null;
	}

}
