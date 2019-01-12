package pro.jing.p04;

import java.awt.font.NumericShaper;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long>{
	
	private final long[] numbers;
	private final int start;
	private final int end;
	
	public static final long THRESHOLD = 10_000;

	public  ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}
	
	public  ForkJoinSumCalculator(long[] numbers, int strat, int end) {
		this.numbers = numbers;
		this.start = strat;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int length = end -start;
		if (length <= THRESHOLD) {
			return computeSequentially();
		}
		
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length /2);
		leftTask.fork();
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length /2, end);
		Long rigthResult = rightTask.compute();
		Long leftResult = leftTask.compute();
		return leftResult + rigthResult;
	}

	private long computeSequentially() {
		long sum = 0;
		for (int i = start;i < end;i++) {
			sum += numbers[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long[] numbers = LongStream.rangeClosed(1, 1_000_000_000).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		System.out.println(new ForkJoinPool().invoke(task));
	}
	
}
