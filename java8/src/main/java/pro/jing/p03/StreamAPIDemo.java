package pro.jing.p03;

import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIDemo {
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.dishedInit();
		printName(menu);
	}

	// 中间操作不会触发执行
	public static void printName(List<Dish> menu) {
		List<String> names = menu.stream().filter(d -> {
			System.out.println("filtering  " + d.getName());
			return d.getCalories() > 300;
		}).map(d -> {
			System.out.println("Mapping " + d.getName());
			return d.getName();
		}).limit(3).collect(Collectors.toList());
		System.out.println(names);
	}
}
