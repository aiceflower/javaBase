package learn.design.pattern.adapter;

public class PlugAdapterExtends extends GBTwoPlug implements PlugInterFace{

	@Override
	public void powerWithThree() {
		System.out.println("使用继承通过adapter把二相转换为三相电流供电");
	}

}
