package learn.basic.base;


public class 方法死循环 {
	private int i = 1;
	public static void main(String[] args) {
		new 方法死循环().test();
	}

	public void test() {
		System.out.println(++i);
		test();
	}
}

class 对象列循环 {
	@SuppressWarnings("unused")
	private 对象列循环 死 = new 对象列循环();
	public static void main(String[] args) {
		new 对象列循环();
	}
}
