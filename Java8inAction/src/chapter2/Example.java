package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		Example e = new Example();
		e.test();
	}
	
	public void test(){
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple("green", 70));
		inventory.add(new Apple("blue", 80));
		inventory.add(new Apple("red", 30));
		inventory.add(new Apple("green", 50));
		inventory.add(new Apple("black", 60));
		System.out.println(Arrays.toString(filterGreenApples(inventory).toArray()));
		
		System.out.println(Arrays.toString(filterApples(inventory, new AppleHeavyWeightPredicate()).toArray()));
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(color.equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if((flag && apple.getColor().equals(color)) || 
					(!flag && apple.getWeight() > weight)){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
}
