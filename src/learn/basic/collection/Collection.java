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
	 * ����ת��Ϊ���飬�޸�����ֵ��ı�ԭ�����е�ֵ
	 * 
	 * @param <T>
	 */
	public T[] collectionToArray(List<? super T> list) {
		T[] array = (T[]) createArray(list.size());
		return list.toArray(array);
	}
	
}
