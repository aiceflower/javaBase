package learn.design.pattern.strategy;

/**
 * Ѽ�ӳ��࣬����Ѽ�Ӷ�Ҫ�̳д���
 * ������Ѽ�ӵ���Ϊ����ʾ������
 * @author Administrator
 *
 */
public abstract class Duck {
	//���Ѽ�ӵĿ�������Ϊ
	private FlyingStrategy flyingStrategy;
	
	public Duck(){
		
	}
	
	
	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy = flyingStrategy;
	}
	

	/**
	 * Ѽ�ӷ���������ͨ����Ϊ���ɳ���ʵ��
	 */
	public void quack(){
		System.out.println("�¸¸¸�");
	}
	
	/**
	 * ��ʾѼ�����
	 * ÿ��Ѽ�ӵ���۶�����ͬ������Ϊ����������ȥʵ��
	 */
	public abstract void display();
	
	public void fly(){
		flyingStrategy.performFly();
	}
}
