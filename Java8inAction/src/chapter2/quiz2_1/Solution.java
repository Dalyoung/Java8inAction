package chapter2.quiz2_1;

import java.util.ArrayList;
import java.util.List;

import chapter2.Apple;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
	
	public void test(){
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple("green", 170));
		inventory.add(new Apple("blue", 180));
		inventory.add(new Apple("red", 130));
		inventory.add(new Apple("green", 150));
		inventory.add(new Apple("black", 160));
		
		prettyPrintApple(inventory, new AppleSimpleFormatter());
		prettyPrintApple(inventory, new AppleFancyFormatter());
	}
	
	public void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
		for(Apple apple : inventory){
			System.out.println(formatter.accept(apple));
		}
	}
}
