package learn.design.pattern.observer;

/**
 * ����һ���۲춼�ӿڣ�����һ�����µĽӿڸ���Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ķ���
 * @author Administrator
 *
 */
public interface Observer {

	/**
	 * ���µĽӿ�
	 * @param subject(����Ŀ����󣬷����ȡ��Ӧ��Ŀ������״̬)
	 */
	void update(Subject subject);

}
