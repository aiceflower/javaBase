package learn.design.pattern.adapter;

/**
 * 二相转三相，及三相转二相适配器
 * @author Administrator
 *
 */
public class PlugAdapter implements PlugInterFace{
	private GBTwoPlug twoPlug;
	
	private GBThreePlug threePlug;
	
	
	/**
	 * 二相国标构造器
	 * @param twoPlug
	 */
	public PlugAdapter(GBTwoPlug twoPlug){
		this.twoPlug = twoPlug;
	}
	
	
	/**
	 * 有三相国标构造器
	 * @param threePlug
	 */
	public PlugAdapter(GBThreePlug threePlug){
		this.threePlug = threePlug;
	}
	
	@Override
	public void powerWithThree() {
		this.twoPlug.powerWithTwo();
		System.out.print("通过adapter转换二相电流变为三相电流供电");
	}

	@Override
	public void powerWithTwo() {
		this.threePlug.powerWithThree();
		System.out.print("通过adapter转换三相电流变为二相电流供电");
	}

}
