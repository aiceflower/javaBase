package learn.design.pattern.chan_of_responsibility.handler;
/**
 * CEO可以批准55%的折扣，超过55%则拒绝
 * @author Administrator
 *
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.55){//处理55%的折扣
			System.out.format("%s批准了折扣:%.4f%n", this.getClass().getName(),discount);
		}else{//如果不能处理，则拒绝
			System.out.format("%s拒绝了折扣:%.4f%n", this.getClass().getName(),discount);
		}
	}
	
}
