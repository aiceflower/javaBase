package learn.basic.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array {
	/**
	 * 数组转换为集合
	 * 
	 * @param a
	 * @return
	 */
	public static List<Integer> arrayToList(Integer[] a) {
		return Arrays.asList(a);
	}

	/**
	 * 打乱数组
	 */
	public static Integer[] shuffle(Integer[] a) {
		List<Integer> list = arrayToList(a);
		Collections.shuffle(list);// 打乱集合
		return list.toArray(new Integer[] {});
	}
}
