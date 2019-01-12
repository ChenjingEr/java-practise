package pro.jing.p06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
	}

	public void main01() {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"));
//		return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))).collect(Collectors.toList());
	}
	
}
