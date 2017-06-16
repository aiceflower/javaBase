package learn.design.pattern.abstractfactory;

/**
 * 新年系列工厂
 * @author Administrator
 *
 */
public class NYFactory implements PersonFactory {

	/*
	 *新年系列男孩 
	 */
	@Override
	public Boy getBoy() {
		return new NYBoy();
	}

	/*
	 *新年系列女孩 
	 */
	@Override
	public Girl getGirl() {
		return new NYGirl();
	}

}
