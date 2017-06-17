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
	 * ���з���ִ��ǰǰִ��һ��,��ִֻ��һ��
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
	 * ÿ������ִ��ǰִ��
	 */
	@Before
	public void before(){
		System.out.println("test before...");
	}
	
	/**
	 * after
	 * ÿ������ִ�к�ִ��
	 */
	@After
	public void after(){
		System.out.println("test after...");
	}
	/**
	 * 
	 * test afterClass
	 * ���з���ִ�к�ִ��һ��,��ִֻ��һ�Σ����beforeClass�ķ����׳��쳣������������ִ��
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
	 * ����ignore������Դ˷���
	 */
	@Ignore
	@Test
	public void ignore(){
		System.out.println("test ignore this method");
	}
	
	/**
	 * test timeout
	 * ��ʱ���Զ���ֹ
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
	 * �����׳�ָ�����쳣��Ȼִ�гɹ�
	 */
	@Test(expected=NullPointerException.class)
	public void expected(){
		System.out.println("test expected...");
		throw new NullPointerException();
	}
	
	/**
	 * �����׼�Suit
	 */
	@Test
	public void suit(){
		System.out.println("please look SuitTest Class...");
	}
	/**
	 * ����һϵ�в���
	 */
	@Test
	public void parameter(){
		System.out.println("please look ParameteTest Class.");
	}
}
