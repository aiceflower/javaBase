package learn.practice;

public class OverrideTest {

	public void info(Object obj,int i){
		System.out.println("obj参数:"+obj);
		System.out.println("int参数:"+i);
	}
	
	public void info(Object obj[],double i){
		System.out.println("obj参数:"+obj);
		System.out.println("int参数:"+i);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		OverrideTest ot = new OverrideTest(); 
		//ot.info(null, 3);这句话编译器无法确定调用的是哪一个方法
		//子类的private的方法如果与父类的private方法一模一样，不算重写	
	}
}
