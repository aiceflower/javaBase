package learn.design.pattern.observer;
/**
 * ����Ĺ۲��߶���ʵ�ָ��·�����ʹ�����״̬��Ŀ���״̬����һ��
 * @author Administrator
 *
 */
public class ConcreteObserver implements Observer{

	//�۲���״̬
	@SuppressWarnings("unused")
	private String observerState;
	
	/**
	 * ��ȡĿ�����״̬��ͬ�����۲��ߵ�״̬��
	 */
	@Override
	public void update(Subject subject) {
		observerState = ((ConcreteSubject)subject).getSubjectState();
	}

}
