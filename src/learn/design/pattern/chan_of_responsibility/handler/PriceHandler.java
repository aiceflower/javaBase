package learn.design.pattern.chan_of_responsibility.handler;
/**
 * �۸����࣬������ͻ��ۿ�����
 * @author Administrator
 *
 */
public abstract class PriceHandler {
	
	/*
	 * ֱ�Ӻ�����ڴ�������
	 */
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor){
		this.successor = successor;
	}
	
	/**
	 * �����ۿ�����
	 * @param discount �ۿ�
	 */
	public abstract void processDiscount(float discount);
	
	
}
