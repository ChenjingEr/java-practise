package pro.jing.p02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author JING 应对不断变更的需求的Java 8变化
 */
public class AppleFilterDemo {

	/**
	 * 需求1：筛选绿苹果
	 */
	public static List<Apple> filterGreenApples(List<Apple> invertory) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : invertory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	/**
	 * 需求02: 筛选红苹果 颜色作为参数
	 */
	public static List<Apple> filterApples(List<Apple> invertory, String color) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : invertory) {
			if (color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	/**
	 * 需求03:区分苹果的和重的水果
	 */
	public static List<Apple> filterApplesByWeight(List<Apple> invertory, int weight) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : invertory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	/**
	 * ByColor, ByWeigiht 违背DRY原则，难以维护 修改对每个属性做筛选 笨拙的做法
	 */
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}
		return result;
	}

	/**
	 * 
	 */
	public static List<Apple> filterApplesByPredicate(List<Apple> invertory, ApplePredicate predicate) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : invertory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		List<Apple> inventory = Arrays.asList(new Apple("green", 80), new Apple("green", 150), new Apple("red", 120));
		
		//用谓词筛选
		List<Apple> heavyApple = filterApplesByPredicate(inventory, new AppleHeavyWeightPredicate());
		List<Apple> greenApple = filterApplesByPredicate(inventory, new AppleGreenColorPredicate());
		
		//用匿名筛选
		List<Apple> redApple = filterApplesByPredicate(inventory, new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});
		
		// 用lambda重写
		List<Apple> redApples = filterApplesByPredicate(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		
		//再次抽象，List类型抽象
	}
}
