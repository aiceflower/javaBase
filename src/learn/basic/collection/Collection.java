package learn.basic.collection;

import java.util.List;

public class Collection {
	/**
	 * 集合转换为数组
	 * 
	 * @param <T>
	 */
	public static Integer[] collectionToArray(List<Integer> list) {
		return list.toArray(new Integer[] {});
	}
}
