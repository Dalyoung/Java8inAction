package chapter2.quiz2_1;

import chapter2.Apple;

public class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple a) {
		String out = a.getWeight() > 150 ? "heavy" : "light";
		return "A " + out + " " + a.getColor() + " apple.";
	}

}
