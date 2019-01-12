package pro.jing.p03;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author JING 构建流
 */
public class StreamApiDemo03 {

	public void method01() throws IOException {
		// 方法1， Stream.of
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
		// 方法2, Stream.empty() 空流
		Stream.empty();
		// 方法3 由数组创建
		int[] numbers = { 2, 3, 4, 5, 6 };
		IntStream stream2 = Arrays.stream(numbers);
		// 方法4 由文件生成
		Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
		lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		// 方法5 无限流,有序
		Stream.iterate(0, n -> n + 2).limit(100).forEach(System.out::println);
		// 方法6 无限流，无序
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
	}

	// 斐波那契元组序列
	public static void practise01() {
	 Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(20)
				.map(t -> t[0]).forEach(System.out::println);
		;
	}
	
	public static void main(String[] args) {
		practise01();
	}

}
