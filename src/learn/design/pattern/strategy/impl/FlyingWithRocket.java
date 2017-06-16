package learn.design.pattern.strategy.impl;

import learn.design.pattern.strategy.FlyingStrategy;

public class FlyingWithRocket implements FlyingStrategy {

	@Override
	public void performFly() {
		System.out.println("ÓÃ»ð¼ý·ÉÐÐ");
	}

}
