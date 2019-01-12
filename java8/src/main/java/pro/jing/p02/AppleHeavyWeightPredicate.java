package pro.jing.p02;

/**
 * @author JING
 * 仅选择重的苹果
 */
public class AppleHeavyWeightPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

}
