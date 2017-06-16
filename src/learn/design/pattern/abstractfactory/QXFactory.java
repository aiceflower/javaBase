package learn.design.pattern.abstractfactory;

public class QXFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new QXBoy();
	}

	@Override
	public Girl getGirl() {
		return new QXGirl();
	}

}
