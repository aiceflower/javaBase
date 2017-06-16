package learn.design.pattern.factory;

public class RightHair implements HairInterface{

	@Override
	public void draw() {
		System.out.println("实现了右偏分发型");
	}
}
