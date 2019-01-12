package pro.jing.p06;

public class Discount {

	public enum Code{
		NONE(0), SLIVER(5),GOLD(10),PLATINUM(15),DIAMOND(20);
		
		private final int percentage;
		Code(int percentage) {
			this.percentage = percentage;
		}
	}
}
