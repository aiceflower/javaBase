package learn.design.pattern.builder;

public interface Item {

	/**
	 * 名称
	 */
	String name();
	
	/**
	 * 包装
	 */
	Packing packing();
	
	/**
	 * 价格
	 */
	float price();
}
