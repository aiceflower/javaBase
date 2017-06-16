package learn.design.pattern.chan_of_responsibility.handler;
/**
 * 销售经理，可以处理30%的折扣
 * @author Administrator
 *
 */
public class Manager extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.3){//处理30%的折扣
			System.out.format("%s批准了折扣:%.4f%n", this.getClass().getName(),discount);
		}else{//如果不能处理，则交给上级处理
			successor.processDiscount(discount);
		}
	}
	
}
