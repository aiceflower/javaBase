package learn.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array{

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
	public static <T> T[] arraycopy(T[] t) {
		return arraycopy(t, 1);
	}
	
	/**
	 * �������ݣ���ָ����С
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] arraycopy(T[] t,int addLength) {
		T[] array = (T[]) java.lang.reflect.Array.newInstance(t.getClass().getComponentType(), t.length + addLength);
		System.arraycopy(t, 0, array, 0, t.length);
		return array;
	}
	
	/**
	 * ����������ϵ�һ��
	 * @param front
	 * @param back
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] concatenate(T[] front,T[] back){
		/*
		 * ʹ�÷��͵ķ�ʽ������һ��ȱ�㣬���͵ķ�ʽ�������ڻ�����������int,boolean...
		 */
		int fLen = front.length;
		int bLen = back.length;
		T[] array = (T[]) java.lang.reflect.Array.newInstance(front.getClass().getComponentType(), fLen + bLen);
		System.arraycopy(front, 0, array, 0, fLen);
		System.arraycopy(back, 0, array, fLen, bLen);
		return array;
	}
}
