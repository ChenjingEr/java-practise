package pro.jing.p07;

import java.time.LocalDate;

public class LocalDateDemo {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2014, 3, 18);
		System.out.println("year : " + date.getYear());
		System.out.println("month : " + date.getMonth());
		System.out.println("date : " + date.getDayOfMonth());
	}
}
