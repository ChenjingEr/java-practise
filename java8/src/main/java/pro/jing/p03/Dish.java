package pro.jing.p03;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dish {
	
	private String name;
	private Integer calories;
	private boolean isVegetarian;

	
	public Dish(String name,Integer calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public static List<Dish> dishedInit() {
		List<Dish> menu = Arrays.asList(new Dish("pork", 800),
				new Dish("beef",700),
				new Dish("chicken",400),
				new Dish("frech fires", 530));
		return menu;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + "]";
	}
}
