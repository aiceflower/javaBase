package learn.design.pattern.chan_of_responsibility;

import java.util.Random;

import learn.design.pattern.chan_of_responsibility.handler.PriceHandler;
import learn.design.pattern.chan_of_responsibility.handler.PriceHandlerFactory;

public class Customer {
	private PriceHandler priceHandler;

	public PriceHandler getPriceHandler() {
		return priceHandler;
	}

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	public void requesDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	public static void main(String[] s){
		Customer c = new Customer();
		c.setPriceHandler(PriceHandlerFactory.createHandler());
		Random random = new Random();
		for(int i = 0 ;i<100;++i){
			System.out.print(i+":");
			c.requesDiscount(random.nextFloat());
		}
	}
}
