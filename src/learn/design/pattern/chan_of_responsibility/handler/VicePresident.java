package learn.design.pattern.chan_of_responsibility.handler;
/**
 * ���۸��ܲã����Դ���50%���ۿ�
 * @author Administrator
 *
 */
public class VicePresident extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.5){//����50%���ۿ�
			System.out.format("%s��׼���ۿ�:%.4f%n", this.getClass().getName(),discount);
		}else{//������ܴ����򽻸��ϼ�����
			successor.processDiscount(discount);
		}
	}
	
}
