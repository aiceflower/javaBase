package learn.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Suit1.class, Suit2.class })
public class SuitTest {
	/**
	 * 测试套件就是组织测试类一起运行的 写一个作为测试套件的入口�?//这个类里不能包含其他的方�?更改测试套件的运行器为Suite.class
	 * //将要测试的类作为数组传入到SuiteClasses�?
	 */
}
