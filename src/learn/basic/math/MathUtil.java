package learn.basic.math;

import java.util.Random;

public class MathUtil {

	/**
	 * 生成0到count之间的随机整数
	 * 
	 * @param count
	 * @return
	 */
	public static int randomInt(final int count) {
		return randomInt(0, count);
	}

	/**
	 * 生成min到max之间的随机整数
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
	 * 使用Math生成min到max之间的随机整数
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
	 * 使用Random生成min到max之间的随机整数
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
