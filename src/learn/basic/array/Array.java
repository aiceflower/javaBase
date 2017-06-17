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
	 * ����ת��Ϊ����,���Լ�������µ�Ԫ��
	 * 
	 * @param a
	 * @return
	 */
	public static <T> List<T> arrayToList(T[] arr) {
		List<T> arraylist = new ArrayList<T>();
		//List<T> asList = Arrays.asList(arr);asList����������µ�Ԫ��
		boolean b = Collections.addAll(arraylist, arr);
		return b?arraylist:null;
	}

	/**
	 * ��������
	 */
	public static <T> T[] shuffle(T[] t) {
		List<T> list = arrayToList(t);
		Collections.shuffle(list);// ���Ҽ���
		return list.toArray(t);
	}

	/**
	 * ��������,Ĭ����1
	 */
	public T[] arraycopy(T[] t) {
		return arraycopy(t, 1);
	}
	
	/**
	 * �������ݣ���ָ����С
	 */
	public T[] arraycopy(T[] t,int addLength) {
		T[] array = createArray(t.length + addLength);
		System.arraycopy(t, 0, array, 0, t.length);
		return array;
	}
}
