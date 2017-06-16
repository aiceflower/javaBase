package learn.basic.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array {
	/**
	 * ����ת��Ϊ����
	 * 
	 * @param a
	 * @return
	 */
	public static List<Integer> arrayToList(Integer[] a) {
		return Arrays.asList(a);
	}

	/**
	 * ��������
	 */
	public static Integer[] shuffle(Integer[] a) {
		List<Integer> list = arrayToList(a);
		Collections.shuffle(list);// ���Ҽ���
		return list.toArray(new Integer[] {});
	}
}
