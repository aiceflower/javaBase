package learn.design.pattern.chan_of_responsibility.handler;
/**
 * 销售副总裁，可以处理50%的折扣
 * @author Administrator
 *
 */
public class VicePresident extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.5){//处理50%的折扣
			System.out.format("%s批准了折扣:%.4f%n", this.getClass().getName(),discount);
		}else{//如果不能处理，则交给上级处理
			successor.processDiscount(discount);
		}
	}
	
}
