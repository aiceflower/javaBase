package learn.design.pattern.strategy.impl;

import learn.design.pattern.strategy.FlyingStrategy;

public class FlyingWithWin implements FlyingStrategy {

	@Override
	public void performFly() {
		System.out.println("Õ¹³á¸ß·É");
	}

}
