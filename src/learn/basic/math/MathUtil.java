package learn.basic.math;

import java.util.Random;

public class MathUtil {

	/**
	 * ����0��count֮����������
	 * 
	 * @param count
	 * @return
	 */
	public static int randomInt(final int count) {
		return randomInt(0, count);
	}

	/**
	 * ����min��max֮����������
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randomInt(final int min, final int max) {
		//randomIntByMath(min,max);
		return randomIntByRandom(min,max);
	}

	/**
	 * ʹ��Math����min��max֮����������
	 * @param min
	 * @param max
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int randomIntByMath(final int min, final int max) {
		if (min < 0 || max >= Integer.MAX_VALUE)
			throw new IllegalArgumentException("n must be positive");
		return min + (int) (Math.random() * (max - min + 1));
	}

	/**
	 * ʹ��Random����min��max֮����������
	 * @param min
	 * @param max
	 * @return
	 */
	private static int randomIntByRandom(final int min, final int max) {
		if (min < 0 || max >= Integer.MAX_VALUE)
			throw new IllegalArgumentException("n must be positive");
		return new Random().nextInt((max - min) + 1) + min;
	}
}
