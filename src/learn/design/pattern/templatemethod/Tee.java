package learn.design.pattern.templatemethod;

public class Tee extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("将柠檬加入杯中");

	}

	@Override
	protected void brew() {
		System.out.println("80度的热水泡茶");
	}

}
