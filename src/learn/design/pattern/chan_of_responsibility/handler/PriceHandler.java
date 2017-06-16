package learn.design.pattern.chan_of_responsibility.handler;
/**
 * 价格处理类，负责处理客户折扣申请
 * @author Administrator
 *
 */
public abstract class PriceHandler {
	
	/*
	 * 直接后继用于传递请求
	 */
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor){
		this.successor = successor;
	}
	
	/**
	 * 处理折扣申请
	 * @param discount 折扣
	 */
	public abstract void processDiscount(float discount);
	
	
}
