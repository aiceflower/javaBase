package learn.design.pattern.chan_of_responsibility.handler;
/**
 * 销售总监，可以处理40%的折扣
 * @author Administrator
 *
 */
public class Director extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.4){//处理40%的折扣
			System.out.format("%s批准了折扣:%.4f%n", this.getClass().getName(),discount);
		}else{//如果不能处理，则交给上级处理
			successor.processDiscount(discount);
		}
	}
	
}
