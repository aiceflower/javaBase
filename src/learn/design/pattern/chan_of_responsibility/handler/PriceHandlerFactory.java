package learn.design.pattern.chan_of_responsibility.handler;

public class PriceHandlerFactory {

	/**
	 * 创建PriceHanlder的工厂方法
	 * @return
	 */
	public static PriceHandler createHandler() {
		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler vp = new VicePresident();
		PriceHandler ceo = new CEO();
		
		sales.setSuccessor(lead);
		lead.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(ceo);
		return sales;
	}

}
