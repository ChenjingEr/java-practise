package pro.jing.p03;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API 数据操作
 */
public class StreamApiDemo02 {

	// 1 筛选素食菜单 filter
	public List<Dish> filterVegetarian(List<Dish> menu) {
		return menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
	}

	// 2 筛选各异的元素
	public static void distinctFilter() {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
	}

	// 3 截短流
	public List<Dish> limitMenu(List<Dish> menu) {
		return menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
	}

	// 4 跳过元素
	public List<Dish> skipMenu(List<Dish> menu) {
		// 跳过前2个元素
		return menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
	}

	// 5 映射， 映射函数作用于每一个元素上，然后创建一组新的元素
	public List<String> mapMenu(List<Dish> menu) {
		return menu.stream().map(Dish::getName).collect(Collectors.toList());
	}

	// 6 扁平流,将作用的元素生成为流的内容
	public void flatStream() {
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		// 映射成流的内容
		List<String> flatWorlds = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());
		System.out.println(flatWorlds);

		// map 映射的是流列表
		List<Stream<String>> streamMapList = words.stream().map(w -> w.split("")).map(Arrays::stream).distinct()
				.collect(Collectors.toList());
	}

	// 7 匹配
	public void anyMatch(List<Dish> menu) {
		// anyMathch返回一个boolean,是个终端操作
		if (menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly !!");
		}
	}

	// 所有匹配
	public void allMatch(List<Dish> menu) {
		boolean allMatch = menu.stream().allMatch(d -> d.getCalories() < 1000);
		System.out.println(allMatch);
	}

	// 没有任何一个元素匹配
	public void noneMatch(List<Dish> menu) {
		boolean noneMatch = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
		System.out.println(noneMatch);
	}

	// 8 查找
	public void findAny(List<Dish> menu) {
		Optional<Dish> findAny = menu.stream().filter(Dish::isVegetarian).findAny();
	}

	// 9 查找第一个元素
	public void findFirst() {
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
	}
	
	// 归约:将流中所有元素反复结合起来，返回一个值
	
	// 10 元素求和
	public void sum() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		//求和
		Integer sum = numbers.stream().reduce(0,(a,b) -> a + b);
		Integer sum01 =  numbers.stream().reduce(0, Integer::sum);
		//累乘
		Integer mul = numbers.stream().reduce(1, (a, b) -> a * b);
	}
	
	// 11 最大值
	public void max() {
		List<Integer> number = Arrays.asList(2,4,3,2,5,7);
		number.stream().reduce(Integer::max);
	}
	
	//原始类型流特特化：减少暗箱操作的成本
	public void mapToPrimative(List<Dish> menu) {
		// intStream　对应的int基本类型的特化流, not Stream<Integer>
		menu.stream().mapToInt(Dish::getCalories).sum();
		// 原始流 -> 一般流
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed();
		//默认值
		OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
		max.orElse(1); //如果值不存在，默认1
	}
	
	// 数值范围
	public void range() {
		//[1,100)的偶数值
		IntStream evenNumber = IntStream.range(1, 100).filter(n -> n % 2 == 0);
		System.out.println(evenNumber.count());
	}
	

	public static void practise() {
		// 2个列表形成数对
		List<Integer> n1 = Arrays.asList(1, 2, 3);
		List<Integer> n2 = Arrays.asList(4, 5);
		List<int[]> pairs = n1.stream().flatMap(i -> n2.stream().map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		List<Stream<int[]>> collect = n1.stream().map(i -> n2.stream().map(j -> new int[] { i, j }))
				.collect(Collectors.toList());

		// 筛选能被3整出的数对
		List<int[]> collect2 = n1.stream()
				.flatMap(i -> n2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		
		// 默认值
	}

	// 查找任何一个对象可以访问其名称
	public static void practise02(List<Dish> menu) {
		menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
	}

	public static void main(String[] args) {
		practise();
	}
}
