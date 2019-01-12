package pro.jing.p02;

/**
 * 一种比添加参数更好的filter解决方案
 * 其中一种解决方案：根据Apple的某些属性返回一个Boolean值
 * 谓词:返回一个boolean值的函数
 * @author JING
 *
 */
public interface ApplePredicate {
	boolean test(Apple apple);
}
