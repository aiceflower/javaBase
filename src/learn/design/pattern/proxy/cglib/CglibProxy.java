package learn.design.pattern.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz){
		//设置创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	/*
	 * 拦截所有目标类方法的调用
	 *参数
	 *obj:目标类的实例
	 *method：目标方法的反射对象
	 *args:方法的参数
	 *proxy：代理类的实例
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("火车开始运行....");
		//代理类调用父类的方法,这里如果使用invoke()方法，有可能会无限循环
		proxy.invokeSuper(obj, args);
		System.out.println("火车运行结束.....");
		return null;
	}

}
