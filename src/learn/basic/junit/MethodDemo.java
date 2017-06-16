package learn.basic.junit;

public class MethodDemo {
	public void showNum() {
		System.out.println(66);
	}

	public void showNum(int num) {
		System.out.println(num);
	}

	public void showNum(String num1, String num2) {
		System.out.println(num1 + "..." + num2);
	}

	public void showNum(String num1, int num2, String num3) {
		System.out.println(num1 + "..." + num2 + "..." + num3);
	}
}
