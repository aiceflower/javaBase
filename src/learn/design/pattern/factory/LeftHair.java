package learn.design.pattern.factory;

public class LeftHair implements HairInterface{

	@Override
	public void draw() {
		System.out.println("实现了左偏分发型");
	}

}
