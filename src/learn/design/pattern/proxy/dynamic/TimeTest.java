package learn.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import learn.design.pattern.proxy.statick.Car;
import learn.design.pattern.proxy.statick.Moveable;

/**
 * JDK动态代理测试类
 * @author Administrator
 *
 */
public class TimeTest {
	public static void main(String[] args){
		Car c = new Car();
		InvocationHandler h = new TimeHandler(c);
		InvocationHandler ih = new LogHandler(c);
		Class<?> cls = c.getClass();
		Class<?> chs = c.getClass();
		Class<?>[] interfaces = cls.getInterfaces();
		Class<?>[] interfaces1 = chs.getInterfaces();
		Class<?>[] inter = new Class<?>[interfaces.length+interfaces.length];
		for(int i = 0 ;i<interfaces.length;i++){
			inter[i] = interfaces[i];
		}
		for(int i = interfaces.length;i<inter.length;i++){
			inter[i]=interfaces1[i-interfaces.length];
		}
		//
		/*
		 *loader类加载器 
		 *interface 实现 接口
		 *时间处理器 InvocationHandler
		 */
		Moveable move = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(), interfaces1, ih);
		
		move.move();
	}
}
