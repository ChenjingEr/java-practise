package pro.jing.p04;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author JING 并行流
 */
public class ParallelStreamApiDemo01 {

	// 实现累加的功能
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	// 用并行流实现累加
	public static long parallelSum(long n) {
		// iterate 会有装箱拆箱操作，从而影响并行 
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	
	// 
	public static long parallelSum02(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}
	
	// 更细化控制遍历流时哪些操作需要并行，哪些需要串行
	public static void mixed(long n) {
		Stream.iterate(1L, i -> i+1).filter(i -> i %2 == 0).sequential().map(i -> i + 1).parallel(); 
	}
}
