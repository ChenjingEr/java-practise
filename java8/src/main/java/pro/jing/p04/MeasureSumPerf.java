package pro.jing.p04;

import java.util.function.Function;

public class MeasureSumPerf {

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
//			System.out.println("Result :" + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

	public static void main(String[] args) {
		System.out.println("Sequential sum done in "
				+ MeasureSumPerf.measureSumPerf(ParallelStreamApiDemo01::sequentialSum, 1_000_000) + "msecs");
		System.out.println("Parallel sum done in "
				+ MeasureSumPerf.measureSumPerf(ParallelStreamApiDemo01::parallelSum, 1_000_000) + " msecs");
		System.out.println("Parallel sum done in "
				+ MeasureSumPerf.measureSumPerf(ParallelStreamApiDemo01::parallelSum02, 1_000_000) + " msecs");
	}
}
