package learn.practice;

import java.util.Random;

public class OtherPractice {

	/*
	 * ��3��booleanֵ����������������Ϊtrue�ŷ���true
	 */
	public static boolean trueOrfalse(boolean a, boolean b, boolean c) {
		int i = new Random().nextInt(4);
		switch (i) {
		case 0:// ��ķ���
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
