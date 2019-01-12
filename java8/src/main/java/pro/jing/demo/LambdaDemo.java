package pro.jing.demo;

/**
 * @author JING
 * Lambda捕获局部变量的限制
 */
public class LambdaDemo {

	public static void main(String[] args) {
		int number = 1;
		//编译错误
		//Local variable number defined in an enclosing scope must be final or effectively final
		Runnable r = () -> System.out.println(number);
//		number = 2;
		new Thread(r).start();
	}
}
