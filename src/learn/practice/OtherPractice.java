package learn.practice;

import java.util.Random;

public class OtherPractice {

	/*
	 * 有3个boolean值，其中有两个以上为true才返回true
	 */
	public static boolean trueOrfalse(boolean a, boolean b, boolean c) {
		int i = new Random().nextInt(4);
		switch (i) {
		case 0:// 最苯的方法
			if ((a && b) || (b && c) || (a && c)) {
				return true;
			} else {
				return false;
			}
		case 1:
			return (a == b) ? a : c;
		case 2:
			return a ? (b || c) : (b && c);
		default:// case 3:
			return a ^ b ? c : a;
		}
	}
}
