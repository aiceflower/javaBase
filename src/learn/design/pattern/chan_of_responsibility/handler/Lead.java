package learn.design.pattern.chan_of_responsibility.handler;
/**
 * С�鳤�����Դ���15%���ۿ�
 * @author Administrator
 *
 */
public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.15){
			System.out.format("%s��׼�ˣ�%.4f%n���ۿ�", this.getClass().getName(),discount);
		}else{
			successor.processDiscount(discount);
		}
	}

}
