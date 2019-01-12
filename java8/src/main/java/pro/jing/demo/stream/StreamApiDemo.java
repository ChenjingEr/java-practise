package pro.jing.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {
	
	public static void main(String[] args) {
//		List<Instrument> instruments = InstrumentGenerator.instrumentList(20);
//		filterDemo(instruments, i -> i.getSeq() > 15);
//		distinctDemo();
//		findDemo();
		flatMapDemo();
	}

	// 筛选
	public static<T> void filterDemo(List<T> instrumentList, Predicate<T> predicate) {
		System.out.println(instrumentList.stream().filter(predicate).collect(Collectors.toList())); 
	}
	
	// distinct 
	public static void distinctDemo() {
		System.out.println(Arrays.stream(new Integer[] {1,1,1,3,2,1,4,3,2}).distinct().collect(Collectors.toList()));
	}
	
	//查找
	public static void findDemo() {
		Stream<Integer> stream = Arrays.stream(new Integer[] {1,1,1,3,2,1,4,3,2});
		// 1. findAny
		System.out.println(stream.filter(i -> i > 3).findAny().get());

		// 2. findFirst ，流只可以消费1次
		Stream<Integer> stream02 = Arrays.stream(new Integer[] {1,1,1,3,2,1,4,3,2});
		System.out.println(stream02.filter(i -> i > 3).findFirst().get());
	}
	
	public static void flatMapDemo() {
		List<String> l1 = new ArrayList<String>();
		l1.add("1");
		List<String> l2 = new ArrayList<String>();
		l2.add("2");
		List<String> l3 = new ArrayList<String>();
		l3.add("3");
		List<List<String>> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		// list<list> -> list
		List<String> after = list.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(after);
	}
}
