package learn.basic.collection;

import java.util.List;

public class Collection {
	/**
	 * ����ת��Ϊ����
	 * 
	 * @param <T>
	 */
	public static Integer[] collectionToArray(List<Integer> list) {
		return list.toArray(new Integer[] {});
	}
}
