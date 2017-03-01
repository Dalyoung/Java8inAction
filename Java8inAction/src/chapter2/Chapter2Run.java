package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter2Run {
	public static void main(String[] args) {
		Chapter2Run c = new Chapter2Run();
		c.test();
	}
	
	public void test(){
		List<Apple> inventory = Arrays.asList(
				new Apple("green", 170)
				, new Apple("green", 160)
				, new Apple("red", 150)
				, new Apple("red", 110)
				, new Apple("green", 120)
				, new Apple("green", 160)
				, new Apple("blue", 170)
				);
		System.out.println(Arrays.toString(filterGreenApples(inventory).toArray()));
		
		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println(Arrays.toString(heavyApples.toArray()));
		System.out.println(Arrays.toString(greenApples.toArray()));
		
		List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});
		System.out.println(Arrays.toString(redApples.toArray()));
		
		List<Apple> redApples2 = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		System.out.println(Arrays.toString(redApples2.toArray()));
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
		System.out.println(Arrays.toString(evenNumbers.toArray()));
		
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
	
	public static<T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T e : list){
			if(p.test(e)){
				result.add(e);
			}
		}
		return result;
	}
}
