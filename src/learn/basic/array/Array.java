package learn.basic.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array<T>{

	private Class<T> type;

	public Array(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	private T[] createArray(int size) {
		return (T[]) java.lang.reflect.Array.newInstance(type, size);
	}

	/**
	 * 数组转换为集合,可以继续添加新的元素
	 * 
	 * @param a
	 * @return
	 */
	public static <T> List<T> arrayToList(T[] arr) {
		List<T> arraylist = new ArrayList<T>();
		//List<T> asList = Arrays.asList(arr);asList不可以添加新的元素
		boolean b = Collections.addAll(arraylist, arr);
		return b?arraylist:null;
	}

	/**
	 * 打乱数组
	 */
	public static <T> T[] shuffle(T[] t) {
		List<T> list = arrayToList(t);
		Collections.shuffle(list);// 打乱集合
		return list.toArray(t);
	}

	/**
	 * 数组扩容,默认扩1
	 */
	public T[] arraycopy(T[] t) {
		return arraycopy(t, 1);
	}
	
	/**
	 * 数组扩容，扩指定大小
	 */
	public T[] arraycopy(T[] t,int addLength) {
		T[] array = createArray(t.length + addLength);
		System.arraycopy(t, 0, array, 0, t.length);
		return array;
	}
}
