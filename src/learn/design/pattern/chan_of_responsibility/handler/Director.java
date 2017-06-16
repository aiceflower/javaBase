package learn.design.pattern.chan_of_responsibility.handler;
/**
 * �����ܼ࣬���Դ���40%���ۿ�
 * @author Administrator
 *
 */
public class Director extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.4){//����40%���ۿ�
			System.out.format("%s��׼���ۿ�:%.4f%n", this.getClass().getName(),discount);
		}else{//������ܴ����򽻸��ϼ�����
			successor.processDiscount(discount);
		}
	}
	
}
