package learn.basic.enums;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public enum EnumDemo {
	hosuccess(1, "已经交接"), hofailure(0, "未交接	");

	private Integer flag;

	private String desc;

	private EnumDemo(Integer flag, String desc) {

		this.flag = flag;
		this.desc = desc;
	}

	public Integer getFlag() {

		return flag;
	}
	public String getDesc() {

		return desc;
	}

	public static EnumDemo get(Integer flag) {

		for (EnumDemo temp : EnumDemo.values()) {
			if (temp.flag.equals(flag)) {
				return temp;
			}
		}
		return null;
	}

	public static EnumDemo getState(String s) {

		try {
			return EnumDemo.valueOf(s.toLowerCase());
		} catch (Exception e) {
			return null;
		}
	}
}
