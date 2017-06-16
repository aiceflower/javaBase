package learn.basic.arithmetic;

import java.util.Arrays;

public class Arithmetic {
	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
		System.out.println(Arrays.toString(a));
		// quickSort(a, 0, a.length - 1);
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	/**
	 * 冒泡排序
	 */
	protected static void bubbleSort(int array[]) {
		if (array == null || array.length == 0) {
			throw new RuntimeException("非法数组！");
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					change(array, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * 选择排序1
	 */
	public static void selectSort(int array[]) {
		int max;
		for (int i = 1; i < array.length; i++) {
			int a[] = Arrays.copyOfRange(array, 0, array.length - i + 1);
			max = getMax(a);
			change(array, max, array.length - i);
		}
	}
	
	/**
	 * 选择排序2
	 * 
	 * @param arr
	 */
	public static void sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int max = getMax(arr, arr.length - i - 1);
			change(arr, max, arr.length - i - 1);
			// System.out.println(Arrays.toString(arr));
		}
	}

	/**
	 * 直接插入排序
	 */
	public static void insertSort(int array[]) {
		int tmp, j;
		for (int i = 0; i < array.length; i++) {
			tmp = array[i];
			for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
				array[j + 1] = array[j];
				System.out.println(Arrays.toString(array) + "...");
			}
			array[j + 1] = tmp;
			System.out.println(Arrays.toString(array) + "------------");
		}
	}

	
	/**
	 * 快速排序
	 */
	public static void quickSort(int sortarray[], int lowIndwx, int highIndex) {
		int lo = lowIndwx;
		int hi = highIndex;
		int mid;
		if (highIndex > lowIndwx) {
			mid = sortarray[(highIndex + lowIndwx) / 2];
			while (lo <= hi) {
				while ((lo < highIndex) && (sortarray[lo] < mid))
					++lo;
				while ((hi > lowIndwx && (sortarray[hi] > mid)))
					--hi;
				if (lo <= hi) {
					change(sortarray, lo, hi);
					++lo;
					--hi;
				}
			}
			if (lowIndwx < hi)
				quickSort(sortarray, lowIndwx, hi);
			if (highIndex > lo)
				quickSort(sortarray, lo, highIndex);
		}
	}

	// 交换数组中指定的两个数
	public static void change(int array[], int x, int y) {
		// System.out.println(x + "..." + y);
		if (x == y)
			return;
		array[x] = array[x] ^ array[y];
		array[y] = array[x] ^ array[y];
		array[x] = array[x] ^ array[y];
	}

	// 查找数组中最大的数
	public static int getMax(int array[]) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[max] < array[i])
				max = i;
		}
		return max;
	}

	// 查找数组中从开始到指定位置的最大值
	public static int getMax(int array[], int index) {
		if (index < 0 || index > array.length - 1)
			throw new RuntimeException("非法索引");
		int max = 0;
		for (int i = 0; i <= index; i++) {
			if (array[max] < array[i])
				max = i;
		}
		return max;
	}
}
