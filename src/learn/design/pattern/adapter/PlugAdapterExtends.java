package learn.design.pattern.adapter;

public class PlugAdapterExtends extends GBTwoPlug implements PlugInterFace{

	@Override
	public void powerWithThree() {
		System.out.println("ʹ�ü̳�ͨ��adapter�Ѷ���ת��Ϊ�����������");
	}

}
