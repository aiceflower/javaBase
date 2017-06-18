package learn.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array{

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
	public static <T> T[] arraycopy(T[] t) {
		return arraycopy(t, 1);
	}
	
	/**
	 * 数组扩容，扩指定大小
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] arraycopy(T[] t,int addLength) {
		T[] array = (T[]) java.lang.reflect.Array.newInstance(t.getClass().getComponentType(), t.length + addLength);
		System.arraycopy(t, 0, array, 0, t.length);
		return array;
	}
	
	/**
	 * 将两个数组合到一起
	 * @param front
	 * @param back
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] concatenate(T[] front,T[] back){
		/*
		 * 使用泛型的方式，但有一个缺点，泛型的方式不适用于基本数据类型int,boolean...
		 */
		int fLen = front.length;
		int bLen = back.length;
		T[] array = (T[]) java.lang.reflect.Array.newInstance(front.getClass().getComponentType(), fLen + bLen);
		System.arraycopy(front, 0, array, 0, fLen);
		System.arraycopy(back, 0, array, fLen, bLen);
		return array;
	}
}
