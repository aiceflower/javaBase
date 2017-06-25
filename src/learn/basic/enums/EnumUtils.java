package learn.basic.enums;

public class EnumUtils {

	/**
	 * 根据string获取Enum对象
	 */
	public static <T extends Enum<T>> T getEnumFromString(Class<T> c,String str){
		if(c !=null && str !=null){
			try {
				return Enum.valueOf(c, str);
			} catch (IllegalArgumentException e) {
				
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		EnumDemo failure = EnumUtils.getEnumFromString(EnumDemo.class, "hofailure");
		System.out.println(failure.getDesc());
		System.out.println(EnumDemo.hofailure.ordinal());
		System.out.println(EnumDemo.hosuccess.ordinal());
	}
}
