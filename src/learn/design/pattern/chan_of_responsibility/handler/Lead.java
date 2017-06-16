package learn.design.pattern.chan_of_responsibility.handler;
/**
 * 小组长，可以处理15%的折扣
 * @author Administrator
 *
 */
public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.15){
			System.out.format("%s批准了，%.4f%n的折扣", this.getClass().getName(),discount);
		}else{
			successor.processDiscount(discount);
		}
	}

}
