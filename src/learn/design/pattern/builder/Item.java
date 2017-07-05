package learn.design.pattern.builder;

public interface Item {

	/**
	 * ����
	 */
	String name();
	
	/**
	 * ��װ
	 */
	Packing packing();
	
	/**
	 * �۸�
	 */
	float price();
}
