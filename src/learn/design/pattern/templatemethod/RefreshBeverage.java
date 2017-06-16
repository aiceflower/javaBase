package learn.design.pattern.templatemethod;

/**
 * ������࣬Ϊ���������ṩһ���㷨���
 * 
 * ��������
 * @author Administrator
 *
 */
public abstract class RefreshBeverage {
	
	/**
	 *�Ʊ����ϵ�ģ�巽��
	 *��װ���������๲ͬ���㷨���
	 *����Ϊfinal��ֹ������д 
	 */
	public final void prepareBeverageTemplate(){
		//[1]��ˮ���
		boilWater();
		//[2]��������
		brew();
		//[3]�����ϵ��뱭��
		pourInCup();
		//[4]�������,�ṩ���ӣ�ѯ�ʿͻ��Ƿ����������
		if(isCustomerWantsCondiments())
		addCondiments();
	}

	/**
	 * �������
	 */
	protected abstract void addCondiments();

	private void pourInCup() {
		System.out.println("�����ϵ��뱭��");
	}

	/**
	 * ��������
	 */
	protected abstract void brew() ;

	/**
	 * ��ˮ侷�
	 */
	private void boilWater() {
		System.out.println("��ˮ侷�");
	}
	
	//���������е��˶��������м������ϣ����ṩ�˹��ӷ���
	/**
	 * ѯ�ʿͻ��Ƿ�������
	 * Hook,���Ӻ������ṩһ���յĻ�Ĭ�ϵ�ʵ��
	 * ���������������о����Ƿ�ҹ��Լ���ιҹ�
	 * @return
	 */
	protected  boolean isCustomerWantsCondiments(){
		return true;
	}
}
