package pro.jing.p03;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author JING 收集器，归约 汇总
 */
public class StreamApiDemo04 {

	// count
	public static void count(List<Dish> menu) {
		long count = menu.stream().count();
		System.out.println(count);
	}

	// 流中的最大值，最小值
	public static void maxOrMin(List<Dish> menu) {
		Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> maxCalories = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		Optional<Dish> minCalories = menu.stream().collect(Collectors.minBy(dishCaloriesComparator));
	}

	// 汇总
	public static void summing(List<Dish> menu) {
		// 累加
		Integer sumCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		// 平均数
		double avgCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		// 总的汇总
		IntSummaryStatistics summarize = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(summarize.getAverage());
		System.out.println(summarize.getCount());
		System.out.println(summarize.getMax());
		System.out.println(summarize.getMin());
		System.out.println(summarize.getSum());
	}

	// 字符串连接
	public static void join(List<Dish> menu) {
		// join 所有的dish name
		String menuName = menu.stream().map(Dish::getName).collect(Collectors.joining());
		// join 所有的dish name, 分隔符为,
		String menuName02 = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
	}

	// 广义上的归约 reduce
	public static void reduce(List<Dish> menu) {
		// 菜单总热量
		Integer sum = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
		// max 热量
		Optional<Dish> max = menu.stream()
				.collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
	}

	// 分组
	public static void groupby(List<Dish> menu) {
		Map<String, List<Dish>> dishesByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return "CaloricLevel.DIET";
			else if (dish.getCalories() <= 700)
				return "CaloricLevel.NORMAL";
			else
				return "CaloricLevel.FAT";
		}));
	}
	
	// 多级分组
	
	// 按照子组搜集数据
	public static void groupby02(List<Dish> menu) {
		Map<String, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getName, Collectors.counting()));
		
	}
	// 分区
	public static void partioned(List<Dish> menu) {
		// 仅由 true， false 2组
		Map<Boolean, List<Dish>> partionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
	}
	
	

}
