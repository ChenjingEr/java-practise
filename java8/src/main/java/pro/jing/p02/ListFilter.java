package pro.jing.p02;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象List类型，使得所有的类都可以使用filter
 * 灵活性，简洁性
 */
public class ListFilter {

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
