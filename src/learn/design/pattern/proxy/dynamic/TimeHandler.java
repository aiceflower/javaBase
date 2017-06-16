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
	 * ʱ�����
	 * ������
	 * proxy ������Ķ���
	 * method ������ķ���
	 * args �����Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long startTime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ.......");
		method.invoke(target);
		long endTime = System.currentTimeMillis();
		System.out.println("������ʻ�����������ܹ���ʻ�ˣ�"+(endTime-startTime)+"����");
		return null;
	}

}
