package learn.basic.base;


public class ������ѭ�� {
	private int i = 1;
	public static void main(String[] args) {
		new ������ѭ��().test();
	}

	public void test() {
		System.out.println(++i);
		test();
	}
}

class ������ѭ�� {
	@SuppressWarnings("unused")
	private ������ѭ�� �� = new ������ѭ��();
	public static void main(String[] args) {
		new ������ѭ��();
	}
}
