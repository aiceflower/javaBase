package learn.basic.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Decimal {

	public String format(double source) {
		DecimalFormat df = new DecimalFormat(".##");
		return df.format(source);
	}

	@Test
	public void test() {
		double d = 3.1415926;

		String result = String.format("%.2f", d);
		System.out.println(Double.parseDouble(result) + 2);
		List<String> list = new ArrayList<String>();
		BigDecimal b = new BigDecimal(d);
		list.add(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
		System.out.println(list);
	}
}
