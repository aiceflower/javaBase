package learn.design.pattern.abstractfactory;

public class DWFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new DWBoy();
	}

	@Override
	public Girl getGirl() {
		return new DWGirl();
	}

}
