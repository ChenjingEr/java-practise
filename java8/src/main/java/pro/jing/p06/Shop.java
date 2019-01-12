package pro.jing.p06;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.Getter;

@Getter
public class Shop {
	
	private String name;

	public Shop(String name) {
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}

	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			double price = calculatePrice(product);
			futurePrice.complete(price);
		}).start();
		return futurePrice;
	}
	// 抛出异常
	public Future<Double> getPriceAsync02(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<Double>();
		new Thread(() -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			} catch (Exception e) {
				futurePrice.completeExceptionally(e);
			}
		}).start();;
		return futurePrice;
	}
	
	public Future<Double> getPriceAsync03(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}

	private double calculatePrice(String product) {
		delay();
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsync("My favorite product");
		long invocationTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Invocation returned after " + invocationTime + " msecs");

		// 执行其他任务
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			double price = futurePrice.get();
			System.out.printf("Price is %.2f%n", price);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		long retrievalTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Price returned after " + retrievalTime + " msecs");

	}
}
