package learn.design.pattern.chan_of_responsibility.handler;
/**
 * CEO������׼55%���ۿۣ�����55%��ܾ�
 * @author Administrator
 *
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.55){//����55%���ۿ�
			System.out.format("%s��׼���ۿ�:%.4f%n", this.getClass().getName(),discount);
		}else{//������ܴ�����ܾ�
			System.out.format("%s�ܾ����ۿ�:%.4f%n", this.getClass().getName(),discount);
		}
	}
	
}
