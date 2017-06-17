package learn.basic.collection;

import java.lang.reflect.Array;
import java.util.List;

public class Collection<T> {

	private Class<T> type;

	public Collection(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	private  T[] createArray(int size) {
		return (T[]) Array.newInstance(type, size);
	}

	/**
	 * 集合转换为数组，修改数组值会改变原集合中的值
	 * 
	 * @param <T>
	 */
	public T[] collectionToArray(List<? super T> list) {
		T[] array = (T[]) createArray(list.size());
		return list.toArray(array);
	}
	
}
