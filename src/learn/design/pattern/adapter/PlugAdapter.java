package learn.design.pattern.adapter;

/**
 * ����ת���࣬������ת����������
 * @author Administrator
 *
 */
public class PlugAdapter implements PlugInterFace{
	private GBTwoPlug twoPlug;
	
	private GBThreePlug threePlug;
	
	
	/**
	 * ������깹����
	 * @param twoPlug
	 */
	public PlugAdapter(GBTwoPlug twoPlug){
		this.twoPlug = twoPlug;
	}
	
	
	/**
	 * ��������깹����
	 * @param threePlug
	 */
	public PlugAdapter(GBThreePlug threePlug){
		this.threePlug = threePlug;
	}
	
	@Override
	public void powerWithThree() {
		this.twoPlug.powerWithTwo();
		System.out.print("ͨ��adapterת�����������Ϊ�����������");
	}

	@Override
	public void powerWithTwo() {
		this.threePlug.powerWithThree();
		System.out.print("ͨ��adapterת�����������Ϊ�����������");
	}

}
