package pro.jing.p02;

/**
 * @author JING
 * 仅是选择绿色的苹果
 */
public class AppleGreenColorPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}
}
