package pro.jing.p03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LowerCaloricDishFilter {

	private List<String> byJava7(List<Dish> menu) {
		List<Dish> lowCaloricDishes = new ArrayList<>();

		for (Dish d : menu) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {

			@Override
			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});

		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}

		return lowCaloricDishesName;
	}

	private List<String> byJava8(List<Dish> menu) {
		List<String> lowCaloricDishedName = menu.stream().filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
		return lowCaloricDishedName;
	}
}
