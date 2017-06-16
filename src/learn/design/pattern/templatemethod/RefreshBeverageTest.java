package learn.design.pattern.templatemethod;

public class RefreshBeverageTest {
	public static void main(String[] args) {
		System.out.println("制备咖啡");
		RefreshBeverage rb = new Cofee();
		rb.prepareBeverageTemplate();
		System.out.println("咖啡制好了");
		System.out.println("---------------------------------");
		System.out.println("制备茶");
		rb = new Tee();
		rb.prepareBeverageTemplate();
		System.out.println("茶制备完成");
	}
}
