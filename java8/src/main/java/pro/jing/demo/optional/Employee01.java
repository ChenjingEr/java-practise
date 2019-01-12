package pro.jing.demo.optional;

import java.util.Optional;

public class Employee01 {

	private Car01 car;

	public Optional<Car01> getCar() {
		return Optional.ofNullable(car);
	}
}
