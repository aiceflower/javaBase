package learn.design.pattern.abstractfactory;

/**
 * ����ϵ�й���
 * @author Administrator
 *
 */
public class NYFactory implements PersonFactory {

	/*
	 *����ϵ���к� 
	 */
	@Override
	public Boy getBoy() {
		return new NYBoy();
	}

	/*
	 *����ϵ��Ů�� 
	 */
	@Override
	public Girl getGirl() {
		return new NYGirl();
	}

}
