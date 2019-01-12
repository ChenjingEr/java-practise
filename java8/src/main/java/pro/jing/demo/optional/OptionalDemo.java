package pro.jing.demo.optional;

import java.util.Optional;

public class OptionalDemo {

	public String getInsuranceName(Employee employee) {
		if (employee != null) {
			Car car = employee.getCar();
			if (car != null) {
				Insurance insurance = car.getInsurance();
				if (insurance != null) {
					return insurance.getName();
				}
			}
		}
		return "UNKNOW";
	}

	public String getInsuranceName01(Employee employee) {
		if (employee == null)
			return "UNKNOW";

		Car car = employee.getCar();
		if (car == null)
			return "UNKNOW";

		Insurance insurance = car.getInsurance();
		if (insurance == null)
			return "UNKNOW";

		return insurance.getName();
	}

	public String getInsuranceName02(Optional<Employee01> employee) {
		return employee.flatMap(Employee01::getCar).flatMap(Car01::getInsurance).map(Insurance::getName)
				.orElse("UNKNOW");
	}
}
