package learn.design.pattern.abstractfactory;

/**
 * 圣诞系列工厂
 * @author Administrator
 *
 */
public class MCFactory implements PersonFactory {

	/* 
	 * 生成圣诞系列男孩
	 */
	@Override
	public Boy getBoy() {
		return new MCBoy();
	}

	/* 
	 * 生成圣诞系列女孩
	 */
	@Override
	public Girl getGirl() {
		return new MCGirl();
	}

}
