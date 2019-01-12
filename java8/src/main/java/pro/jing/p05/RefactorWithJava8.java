package pro.jing.p05;

public class RefactorWithJava8 {

	// 匿名类用 lambda表示
	public static void refactor01() {
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
			}
		};
		
		Runnable r2 = () -> System.out.println("Hello");
	}
	
	//匿名类与lambda不同之处
	public static void refactor02() {
		int a = 10; // 匿名类可以屏蔽类外的变量，lambda不可以
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				int a = 2;
				System.out.println(a);
			}
		};
		
		Runnable r2 = () ->{
			//int a = 2; 编译错误
			System.out.println("Hello");
		};
		
	}
}
