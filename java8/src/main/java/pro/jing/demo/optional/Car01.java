package pro.jing.demo.optional;

import java.util.Optional;

public class Car01 {

	private Insurance insurance;
	
	public Optional<Insurance> getInsurance() {
		return Optional.ofNullable(insurance);
	}
	
}
