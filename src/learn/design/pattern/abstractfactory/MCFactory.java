package learn.design.pattern.abstractfactory;

/**
 * ʥ��ϵ�й���
 * @author Administrator
 *
 */
public class MCFactory implements PersonFactory {

	/* 
	 * ����ʥ��ϵ���к�
	 */
	@Override
	public Boy getBoy() {
		return new MCBoy();
	}

	/* 
	 * ����ʥ��ϵ��Ů��
	 */
	@Override
	public Girl getGirl() {
		return new MCGirl();
	}

}
