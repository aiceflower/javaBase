package learn.junit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitTest {
	/**
	 * test beforeClass
	 * 所有方法执行前前执行一次,且只执行一次
	 */
	@SuppressWarnings("unused")
	@BeforeClass
	public static void beforeClass(){
		if(1==2)
		throw new RuntimeException();
		System.out.println("test beforeClass...");
		System.out.println();
	}
	
	/**
	 * before
	 * 每个方法执行前执行
	 */
	@Before
	public void before(){
		System.out.println("test before...");
	}
	
	/**
	 * after
	 * 每个方法执行后执行
	 */
	@After
	public void after(){
		System.out.println("test after...");
	}
	/**
	 * 
	 * test afterClass
	 * 所有方法执行后执行一次,且只执行一次，如果beforeClass的方法抛出异常，本方法照样执行
	 */
	@AfterClass
	public static void afterClass(){
		System.out.println();
		System.out.println("test afterClass...");
	}
	
	@Test
	public void body(){
		System.out.println("method body");
	}
	
	/**
	 * 测试ignore，会忽略此方法
	 */
	@Ignore
	@Test
	public void ignore(){
		System.out.println("test ignore this method");
	}
	
	/**
	 * test timeout
	 * 到时间自动终止
	 */
	@Test(timeout=2000)
	public void timeout(){
		System.out.println("test timeout...");
		while(true){
			System.out.println(System.currentTimeMillis());
		}
	}
	/**
	 * test expected
	 * 方法抛出指定的异常仍然执行成功
	 */
	@Test(expected=NullPointerException.class)
	public void expected(){
		System.out.println("test expected...");
		throw new NullPointerException();
	}
	
	/**
	 * 测试套件Suit
	 */
	@Test
	public void suit(){
		System.out.println("please look SuitTest Class...");
	}
	/**
	 * 测试一系列参数
	 */
	@Test
	public void parameter(){
		System.out.println("please look ParameteTest Class.");
	}
}
