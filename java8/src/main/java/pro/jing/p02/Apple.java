package pro.jing.p02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple {

	private String color;
	private Integer weight;

	public Apple() {}
	public Apple(String color, Integer weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	
}
