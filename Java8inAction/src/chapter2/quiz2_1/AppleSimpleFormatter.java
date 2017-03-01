package chapter2.quiz2_1;

import chapter2.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple a) {
		return "An apple of " + a.getWeight() + "g.";
	}

}
